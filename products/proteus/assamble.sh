#!/bin/bash -e

VICCI_RUNTIME_PATH="vicci-runtime"
VICCI_RUNTIME_BIN_PATH="bin"
VICCI_RUNTIME_BUILD_PATH="target"
SHADED_JAR_NAME="eu.vicci.proteus-1.0.0-SNAPSHOT.jar"

mkdir -p "$VICCI_RUNTIME_PATH/$VICCI_RUNTIME_BIN_PATH"

cp vicci-runtime.bat $VICCI_RUNTIME_PATH/vicci-runtime.bat
cp vicci-runtime.sh $VICCI_RUNTIME_PATH/vicci-runtime.sh
cp server.conf $VICCI_RUNTIME_PATH/server.conf
cp $VICCI_RUNTIME_BUILD_PATH/$SHADED_JAR_NAME $VICCI_RUNTIME_PATH/$VICCI_RUNTIME_BIN_PATH/$SHADED_JAR_NAME

zip -r vicci-runtime.zip vicci-runtime
