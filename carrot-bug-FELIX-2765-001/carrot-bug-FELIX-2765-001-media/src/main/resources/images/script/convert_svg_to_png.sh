#!/bin/bash

# provides "rsvg-convert"
# sudo apt-get install librsvg2-bin

# provides "convert"
# sudo apt-get install imagemagick

echo "###### generate png from svg"

function from_svg_into_png() {

	local SRC=$1
  	local TGT=$2
	local W=$3
	local H=$4

	rsvg-convert $SRC --format=png --width=$W --height=$H --output $TGT"_"$W"x"$H.png
	
	# makes corrupt crc
	#convert -verbose -antialias -background none -depth 16 -compress none svg:$SRC -scale $W"x"$H $TGT"_"$W"x"$H.png
  
}

INPUT="$1"
BRAND="$2"
OUTPUT="$3"

SOURCE="$INPUT/$BRAND/logo_256x256.svg"
TARGET="$OUTPUT/$BRAND/logo"

from_svg_into_png "$SOURCE" "$TARGET" "16" "16"
from_svg_into_png "$SOURCE" "$TARGET" "24" "24"
from_svg_into_png "$SOURCE" "$TARGET" "32" "32"
from_svg_into_png "$SOURCE" "$TARGET" "48" "48"
from_svg_into_png "$SOURCE" "$TARGET" "64" "64"
from_svg_into_png "$SOURCE" "$TARGET" "96" "96"
from_svg_into_png "$SOURCE" "$TARGET" "128" "128"
from_svg_into_png "$SOURCE" "$TARGET" "256" "256"

