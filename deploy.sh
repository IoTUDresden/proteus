#!/bin/bash -e

git config --global user.name "Travis CI"
git config --global user.email "someEmail@email.org"

travisBuildPath="/home/travis/build"

p2TargetPath="sites/p2/target/repository"
mavenTargetPath="target/repo"

p2DeployPath ="repo/p2/latest"
mavenDeployPath="repo/maven/snapshot"

userName="andiikaa"
repoName="proteus"
tmpRepoName="proteus-tmp"


git clone https://github.com/$userName/$repoName.git $travisBuildPath/$userName/$tmpRepoName
cd $travisBuildPath/$userName/$tmpRepoName
git checkout gh-pages

rm -r $p2DeployPath
rm -r $mavenDeployPath

mkdir -p $p2DeployPath
mkdir -p $mavenDeployPath

cp -r $travisBuildPath/$userName/$repoName/$p2TargetPath/. $travisBuildPath/$userName/$tmpRepoName/$p2DeployPath/
cp -r $travisBuildPath/$userName/$repoName/$mavenTargetPath/. $travisBuildPath/$userName/$tmpRepoName/$mavenDeployPath/

git add -A
git commit -m "deploy p2 and maven repo"
git push --force --quiet "https://${GH_TOKEN}@${GH_REF}" gh-pages