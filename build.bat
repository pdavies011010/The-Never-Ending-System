del /Q classes\* 
del /Q bin\*
javac -d classes\ -cp lib\processing-1.2.1\core.jar src\com\tnes\*.java
jar cmf Manifest.mf bin\tnes.jar -C classes com