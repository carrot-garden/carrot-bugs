#!/bin/bash

# sudo apt-get install imagemagick

echo "###### generate all"

INPUT="$1"
BRAND="$2"
OUTPUT="$3"

echo "###### INPUT=$INPUT"
echo "###### BRAND=$BRAND"
echo "###### OUTPUT=$OUTPUT"


THIS_PATH=$(dirname $(readlink -f $0))

echo "###### THIS_PATH=$THIS_PATH"

$THIS_PATH/convert_svg_to_png.sh "$INPUT" "$BRAND" "$OUTPUT"

$THIS_PATH/convert_png_to_ico.sh "$INPUT" "$BRAND" "$OUTPUT"


  