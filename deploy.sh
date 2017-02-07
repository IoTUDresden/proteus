#!/bin/bash -e

git config --global user.name "Travis CI"
git config --global user.email "someEmail@email.org"

travisBuildPath="/home/travis/build"

p2TargetPath="sites/p2/target/repository"
mavenTargetPath="target/repo"

p2DeployPath="p2/latest"
mavenDeployPath="maven/snapshot"

userName="IoTUDresden"
ghUserName="IoTUDresden"
repoName="proteus-repo"
tmpRepoName="proteus-repo"
proteusRepo="proteus"

git clone https://github.com/$ghUserName/$repoName.git $travisBuildPath/$userName/$tmpRepoName
cd $travisBuildPath/$userName/$tmpRepoName
git checkout gh-pages

rm -r "$p2DeployPath"
rm -r "$mavenDeployPath"

mkdir -p "$p2DeployPath"
mkdir -p "$mavenDeployPath"

cp -r $travisBuildPath/$userName/$proteusRepo/$p2TargetPath/. $travisBuildPath/$userName/$tmpRepoName/$p2DeployPath/
cp -r $travisBuildPath/$userName/$proteusRepo/$mavenTargetPath/. $travisBuildPath/$userName/$tmpRepoName/$mavenDeployPath/

chmod a+x update-directory-index.sh
./update-directory-index.sh

git add -A
git commit -m "deploy p2 and maven repo"
git push --force --quiet "https://${GH_TOKEN}@${GH_REF}" gh-pages > /dev/null 2>&1