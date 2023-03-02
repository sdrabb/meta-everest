LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/everest-utils.git;branch=main;protocol=https"

SRCREV = "a6a48251105ee550e50d8d6dd76485bd820067e1"
PV = "0.0.19"

S = "${WORKDIR}/git"

SETUPTOOLS_SETUP_PATH = "${S}/ev-dev-tools"

inherit setuptools3

do_configure:prepend() {
cat > ${SETUPTOOLS_SETUP_PATH}/setup.py <<-EOF
from setuptools import setup

setup()
EOF
}

DEPENDS = "python3-pip-native"

RDEPENDS:${PN} = " \
    pip-stringcase \
    python3-jsonschema \
    python3-pyyaml \
    python3-jinja2 \
"

BBCLASSEXTEND = "native"
