
String goat = 'goat'
String car = 'car'
Integer allWins = 0

String[] contest = new String[3]

List doors = [0,1,2]

100.times {
    Integer carPosition = Math.abs(new Random().nextInt() % doors.size())
    contest[carPosition] = car
    contest.eachWithIndex { value, index ->
        if(!value) {
            contest[index] = goat
        }
    }

    //El concursante elige una puerta
    Integer player = Math.abs(new Random().nextInt() % doors.size())

    //El presentador abre una puerta que NO es la elegida por el concursante y tiene una cabra
    Integer openDoor = contest[(doors - doors[player]).first()] == goat ?
        (doors - doors[player]).first() :
        (doors - doors[player]).last()

    //Obtenemos la puerta que ofrece el presentador para cambiar (Es la que NO ha elegido el concursante ni la abierta)
    doors = doors - player
    doors = doors - openDoor

    //Si cambiamos de puerta y está el coche, ganamos!!!
    if(contest[doors.first()] == car) {
        allWins++
    }

    contest = new String[3]
    doors = [0,1,2]
}

println "All wins: $allWins"

