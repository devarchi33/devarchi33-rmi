#command
1. 컴파일 : javac -d . src/IHello.java src/RmiServer.java src/RmiClient.java
2. 서버 실행 : java -classpath . -Djava.rmi.server.codebase=file:./ RmiServer &
3. 클라이언트 실행 : java -classpath . -Djava.rmi.server.codebase=file:./ RmiClient &

