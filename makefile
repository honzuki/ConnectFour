run = ConnectFour
main = ConnectFour.java
core = ./Core/Board.java ./Core/BoardCheckFunction.java ./Core/BoardDisplayFunction.java ./Core/Disc.java ./Core/FullColumnException.java ./Core/Game.java ./Core/GameOverException.java ./Core/Player.java
gui = ./Gui/GameFrame.java ./Gui/BoardPanel.java ./Gui/ControlsPanel.java
 
run:
	java $(run)
 
compile: 
	javac $(gui) $(core) $(main)
 
linux_run: linux_compile
	/usr/lib/jvm/java-8-openjdk-amd64/bin/java $(run)
 
linux_compile: 
	/usr/lib/jvm/java-8-openjdk-amd64/bin/javac $(gui) $(core) $(main)