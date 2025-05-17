# shellcheck disable=SC1113
#/bin/sh

# shellcheck disable=SC2061
# shellcheck disable=SC2035
find . -name "*.java" -exec java -jar format.jar --replace {} +
