jdk-7u79-windows-x64.exe /s /INSTALLDIR=C:\java7\ ADDLOCAL="ToolsFeature,SourceFeature,PublicjreFeature"
SETX PATH "%PATH%;C:\java7\bin\"
echo ..\minecraft-forge\eclipse\ | clip
cd ..\minecraft\eclipse\
eclipse.exe
cd ..\..\greenfoot\greenfoot-bluej\
bluej.exe
greenfoot.exe