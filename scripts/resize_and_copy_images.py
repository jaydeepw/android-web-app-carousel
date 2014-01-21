import os

IC_LAUNCHER_LDPI = '36'
IC_LAUNCHER_MDPI = '48'
IC_LAUNCHER_HDPI = '72'
IC_LAUNCHER_XHDPI = '96'
IC_LAUNCHER_XXHDPI = '144'

print "Resizing and copying the images to respective density directories."

# run the command to resize the image.
os.system("convert config/images/masterimages/ic_launcher.png -resize " + IC_LAUNCHER_LDPI + "x" + IC_LAUNCHER_LDPI + " res/drawable-ldpi/ic_launcher.png")
os.system("convert config/images/masterimages/ic_launcher.png -resize " + IC_LAUNCHER_MDPI + "x" + IC_LAUNCHER_MDPI + " res/drawable-mdpi/ic_launcher.png")
os.system("convert config/images/masterimages/ic_launcher.png -resize " + IC_LAUNCHER_HDPI + "x" + IC_LAUNCHER_HDPI + " res/drawable-hdpi/ic_launcher.png")
os.system("convert config/images/masterimages/ic_launcher.png -resize " + IC_LAUNCHER_XHDPI + "x" + IC_LAUNCHER_XHDPI + " res/drawable-xhdpi/ic_launcher.png")
os.system("convert config/images/masterimages/ic_launcher.png -resize " + IC_LAUNCHER_XXHDPI + "x" + IC_LAUNCHER_XXHDPI + " res/drawable-xxhdpi/ic_launcher.png")
