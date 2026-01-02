# Customize base system files for Yoseli
# Our files/poky/motd overrides meta-poky's version via FILESEXTRAPATHS
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
