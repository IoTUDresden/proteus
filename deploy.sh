#!/bin/bash -e

# This script will deploy assamble all stuff from the build folders
# and push artifacts to the p2 and maven repository.
# Editor builds and vicci-runtime builds are copied to a folder,
# which can be published to Github releases via the travis provider: releases.

git config --global user.name "Travis CI"
git config --global user.email "someEmail@email.org"

# the base path where travis will put build artifacts
#TRAVIS_BUILD_PATH="/home/travis/build"
# the path for the binary p2 repo
P2_TARGET_PATH="sites/p2/target/repository"
# the path for the binary maven repo
MAVEN_TARGET_PATH="target/repo"
# the path where the p2 repo should be deployed
P2_DEPLOY_PATH="p2/latest"
# the path where the p2 repo should be deployed
MAVEN_DEPLOY_PATH="maven/snapshot"
# Releases path. All files in here are deployed to gh releases.
#RELEASES_PATH="bin_release"
# Path where the editor zip files located (maven has already packed them)
EDITOR_PATH="products/editor/target/products"
# proteus shaded path
PROTEUS_SHADED_PATH="products/proteus"

# user name for travis user
#USER_NAME="IoTUDresden"
# user name for github user (where the repo is from)
GH_USER_NAME="IoTUDresden"
# gh project name for the repo (p2 and maven)
REPO_NAME="proteus-repo"
# repo is cloned to this folder
TMP_REPO_NAME="proteus-repo"
# name for the proteus project
PROTEUS_NAME="proteus"



################################
# Preparing the release folder #
################################

echo "prepare Github Releases..."

mkdir -p "$TRAVIS_BUILD_PATH/$USER_NAME/$RELEASES_PATH"

echo "copy editor build to release..."

cd $TRAVIS_BUILD_PATH/$USER_NAME/$PROTEUS_NAME/$EDITOR_PATH
find . -name '*.zip' -exec mv {} "$TRAVIS_BUILD_PATH/$USER_NAME/$RELEASES_PATH" \;

echo "assamble vicci-runtime and copy to release..."

cd $TRAVIS_BUILD_PATH/$USER_NAME/$PROTEUS_NAME/$PROTEUS_SHADED_PATH
chmod a+x assamble.sh
./assamble.sh

cp -r $TRAVIS_BUILD_PATH/$USER_NAME/$PROTEUS_NAME/$PROTEUS_SHADED_PATH/vicci-runtime.zip $TRAVIS_BUILD_PATH/$USER_NAME/$RELEASES_PATH/vicci-runtime.zip

###########################
# Deploy the repositories #
###########################

echo "cloning the target p2 and maven repository..."

git clone https://github.com/$GH_USER_NAME/$REPO_NAME.git $TRAVIS_BUILD_PATH/$USER_NAME/$TMP_REPO_NAME
cd $TRAVIS_BUILD_PATH/$USER_NAME/$TMP_REPO_NAME
git checkout gh-pages

echo "copy binaries to repository..."


# todo we should only override snapshots or the same version, at least for the maven part.
rm -r "$P2_DEPLOY_PATH"
rm -r "$MAVEN_DEPLOY_PATH"

mkdir -p "$P2_DEPLOY_PATH"
mkdir -p "$MAVEN_DEPLOY_PATH"

cp -r $TRAVIS_BUILD_PATH/$USER_NAME/$PROTEUS_NAME/$P2_TARGET_PATH/. $TRAVIS_BUILD_PATH/$USER_NAME/$TMP_REPO_NAME/$P2_DEPLOY_PATH/
cp -r $TRAVIS_BUILD_PATH/$USER_NAME/$PROTEUS_NAME/$MAVEN_TARGET_PATH/. $TRAVIS_BUILD_PATH/$USER_NAME/$TMP_REPO_NAME/$MAVEN_DEPLOY_PATH/

echo "update directory index of the repository..."

chmod a+x update-directory-index.sh
./update-directory-index.sh

echo "commit and push the repository..."

git add -A
git commit -m "deploy p2 and maven repo"
# this does a silent commit and also does not show any errors. So the token will should not be vissible in the travis log
git push --force --quiet "https://${GH_TOKEN}@${GH_REF}" gh-pages > /dev/null 2>&1

###########################
# Deploy the docker image #
###########################

echo "deploying docker image..."
docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD 
docker push iotudresden/vicci-runtime