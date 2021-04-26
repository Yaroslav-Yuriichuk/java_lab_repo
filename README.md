The task was to:
1. Write code to lab2:
  My variant:
  Implement hierarchy of shipping options. Add possibility of searching options within certain price range and return list. sorted by delivery time.
  Implement possibility of sorting options by price and delivery time in ascending or descending order.
2. Follow python code conventions.
3. Organize code with packages.
4. Cut down working with console.
5. Write code strictly according class diagram.
6. For sorting use built in java functions.
7. Use Enum and not use static attributes.
8. Make project be able to be run as maven
9. Connect following plugins:
        1). Jacoco,
        2). FindBugs,
        3). PMD,
        4). CheckStyle.
To run:
1. Make sure you have java and maven installed and enviroment variables set.
2. Clone the repo.
3. Go to that folder
4. In cmd type "**mvn install**".
5. Then type "**java -jar target\shipping-1.0-SNAPSHOT.jar**".
6. To check for bugs and code conventions type "**mvn site**"
7. In target\site open index.html.
