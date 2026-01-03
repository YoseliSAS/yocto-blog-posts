SUMMARY = "Yoseli base image"
DESCRIPTION = "A minimal embedded Linux image for the Yoseli platform"
LICENSE = "MIT"

inherit core-image

# Base packages
IMAGE_INSTALL = "\
    packagegroup-core-boot \
    ${CORE_IMAGE_EXTRA_INSTALL} \
"

# Our applications
IMAGE_INSTALL += "\
    hello \
"

# SSH access
IMAGE_FEATURES += "ssh-server-dropbear"
IMAGE_INSTALL += "openssh-sftp-server"

# User accounts
inherit extrausers

# Password hash - override via secrets.yml or environment variable
# Default password is "yoseli" (for development only!)
# Generate your own with: mkpasswd -m sha-512 yourpassword
YOSELI_PASSWORD ?= "\$6\$16Xfrd9uDJdj4SKx\$8R2G/GZuIAh6K1pKMIk9j6ZtbiNXUam3vo9M8n/5Ljyy5M2B9KLNIWZ9x8rkCOvoeCcbnMntaNhDD2jXnsX1I1"

EXTRA_USERS_PARAMS = "\
    useradd -m -s /bin/sh -G wheel yoseli; \
    usermod -p '${YOSELI_PASSWORD}' yoseli; \
    usermod -p '${YOSELI_PASSWORD}' root; \
"

# Image size (for SD cards)
IMAGE_ROOTFS_EXTRA_SPACE = "262144"
