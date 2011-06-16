#!/bin/bash

# provides "convert"
# sudo apt-get install imagemagick

echo "###### generate ico from png"

function from_png_into_ico() {

	local SRC=$1
	local TGT=$2
	local W=$3
	local H=$4

	convert png:$SRC -scale $W"x"$H $TGT"_"$W"x"$H.ico
  
}

INPUT="$1"
BRAND="$2"
OUTPUT="$3"

SOURCE="$OUTPUT/$BRAND/logo_256x256.png"
TARGET="$OUTPUT/$BRAND/logo"

# make individual icon files
from_png_into_ico "$SOURCE" "$TARGET" "16" "16"
from_png_into_ico "$SOURCE" "$TARGET" "24" "24"
from_png_into_ico "$SOURCE" "$TARGET" "32" "32"
from_png_into_ico "$SOURCE" "$TARGET" "48" "48"
from_png_into_ico "$SOURCE" "$TARGET" "64" "64"
from_png_into_ico "$SOURCE" "$TARGET" "96" "96"
from_png_into_ico "$SOURCE" "$TARGET" "128" "128"
from_png_into_ico "$SOURCE" "$TARGET" "256" "256"

# make multi page icon bundle file
convert -verbose -adjoin \
  "$TARGET"_16x16.png \
  "$TARGET"_24x24.png \
  "$TARGET"_32x32.png \
  "$TARGET"_48x48.png \
  "$TARGET"_64x64.png \
  "$TARGET"_96x96.png \
  "$TARGET"_128x128.png \
  "$TARGET"_256x256.png \
  "$TARGET"_bundle.ico

  