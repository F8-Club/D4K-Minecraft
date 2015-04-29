jdk-7u79-windows-x64.exe /s /INSTALLDIR=C:\java7\ ADDLOCAL="ToolsFeature,SourceFeature,PublicjreFeature"
SETX PATH "%PATH%;C:\java7\bin\"
cd LEGO\
setup.exe /q /acceptlicenses yes /r:f