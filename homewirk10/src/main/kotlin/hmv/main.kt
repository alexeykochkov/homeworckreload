import hmv.*
import kotlin.random.Random


fun test0() {
    var a = Ammo.FIRE_BULLET
    var damage1 = a.getCurrentDamage()
    var b = Ammo.ATOMIC_BULLET
    var damage2 = b.getCurrentDamage()
}




/////////////////////////////////////
//class MyMessageNumberFormatException: Throwable(message = "можно вводить только числа") {}

class Team() {

    fun create(targetTeamSize: Int = chooseVolumeOfArmy()): MutableList<AbstractWarrior> {

        var team = mutableListOf<AbstractWarrior>()
        for (e in 0..targetTeamSize - 1) {
            var luck = Random.nextInt(0, 99)
            when (luck) {
                in 0..10 -> team.add(General())
                in 10..30 -> team.add(Capitan())
                else -> team.add(Solder())
            }
        }
        return team
    }

    fun chooseVolumeOfArmy(): Int {
        println("please enter how many unit's in army")
        try {
            var unitsVolume = readln().toInt()
            while (unitsVolume < 0) {
                println("volume must be positive")
                unitsVolume = readln().toInt()
            }
            return unitsVolume
        } catch (e: NumberFormatException) {
            println("need to be Int")
            return chooseVolumeOfArmy()
        }
    }
}




//        try {
//            while (unitsVolume < 0) {
//                println("volume must be positive")
//                unitsVolume = readln().toInt()
//            }
//        } catch (error: MyMessageNumberFormatException) {
//            while (unitsVolume < 0) {
//                println(error.message)
//                unitsVolume = readln().toInt()
//            }
//        }
//        return unitsVolume
//    }
//}





//        while (unitsVolume ==  ) {
//            println("volume must be a number")
//            unitsVolume = readln().toInt()
//        }
//        return unitsVolume
//    }
//}


    class Battle() {

        var teamOne_ = Team().create()
        var teamTwo_ = Team().create()
        var finished_ = false

        fun printState () {
            teamOne_.forEach { println("HP T1 - ${it.healpoints_}")}
            teamTwo_.forEach { println("HP T2 -${it.healpoints_}") }

            println(teamOne_.size)
            println(teamTwo_.size)

            if (teamOne_.isEmpty()) {
                println("team 2 win")

            } else if (teamTwo_.isEmpty()) {
                println("team 1 win")

            }
        }

        fun iterate() {
//        var player1 = Capitan ()
//        var palyer2 = General ()
//        player1.attack(palyer2)
//        palyer2.attack(player1)
//        println("${player1.isDead()} ${palyer2.isDead()}")
//        finished_ = true
//        return
            // fight
//            TODO (логика ебать от меня, спасибо нахуй 1)
            run {

                for (i in teamOne_) {
                    var unit1 = teamOne_.random()
                    var unit2 = teamTwo_.random()
                    unit1.attack(unit2)

                    println(" Team 1 atace Team 2 - Unit ${unit1} atake ${unit2}")
                }
                for (i in teamTwo_) {
                    var unit1 = teamOne_.random()
                    var unit2 = teamTwo_.random()
                    unit2.attack(unit1)
                    println("Team 2 atace Team 1 - Unit ${unit2} atake ${unit1}")
                }

                var team1 =teamOne_.filter {
                    warrior: AbstractWarrior ->
                    warrior.healpoints_ > 0
                }

                var team2 =teamTwo_.filter {
                        warrior: AbstractWarrior ->
                    warrior.healpoints_ > 0
                }

                teamOne_= team1 as MutableList<AbstractWarrior>
                teamTwo_= team2 as MutableList<AbstractWarrior>



                if (teamOne_.isEmpty()) {

                    finished_ = true
                } else if (teamTwo_.isEmpty()) {

                    finished_ = true
                }

//                finished_= true
            }


//            TODO (логика ебать от меня, спасибо нахуй 2)
//            run {
//
//                for (i in 0..teamOne_.size - 1) {
//                    teamOne_[i].attack(teamTwo_[teamOne_.size - 1 - i])
//                    teamOne_.forEach { warrior: AbstractWarrior ->
//                        if (warrior.healpoints_ <= 0)
//                            teamOne_.remove(warrior)
//                        println("is Alive team 1 ${teamOne_}")
//                        println("HP team 1 ${warrior.healpoints_}")
//                        teamTwo_.forEach { warrior: AbstractWarrior ->
//                            if (warrior.healpoints_ <= 0)
//                                teamTwo_.remove(warrior)
//                            println("is Alive team 2 ${teamTwo_}")
//                            println("HP team 2 ${warrior.healpoints_}")
//                        }
//                    }
//                }
//
//                for (i in 0..teamTwo_.size - 1) {
//                    teamTwo_[i].attack(teamOne_[teamTwo_.size - 1 - i])
//                    teamOne_.forEach { warrior: AbstractWarrior ->
//                        if (warrior.healpoints_ <= 0)
//                            teamTwo_.remove(warrior)
//                        println("is Alive team 1 ${teamTwo_}")
//                        println("HP team 1 ${warrior.healpoints_}")
//                        teamOne_.forEach { warrior: AbstractWarrior ->
//                            if (warrior.healpoints_ <= 0)
//                                teamOne_.remove(warrior)
//                            println("is Alive team 2 ${teamOne_}")
//                            println("HP team 2 ${warrior.healpoints_}")
//                        }
//                    }
//                }
//                teamOne_.forEach { warrior: AbstractWarrior ->
//                    println("warrior team 1 ${warrior.isDead()} is dead")
//                }
//                teamTwo_.forEach { warrior: AbstractWarrior ->
//                    println("warrior team 2 ${warrior.isDead()} is dead")
//                }
//
//                finished_ = true
//            }






//            for (i in 0..teamOne_.size - 1) {
//                teamOne_[i].attack(teamTwo_[teamOne_.size - 1 - i])
//                for (j in 0..teamOne_.size - 1) {
//                    teamOne_[i].attack(teamTwo_[j])
//                }
//                teamTwo_[i].attack(teamOne_[i])
//            }
//            finished_ = true
//
//
//            // remoove killed
//            teamOne_


//            TODO("alex вот такую вот хуйню я написал" ).
//            kotlin.run { println("[!]")
//                var teamOneOne = teamOne_
//                teamOneOne = teamOneOne.filter { it.healpoints_ !== 0 } as MutableList<AbstractWarrior>
//                println("results T1 ${teamOneOne}")
//
//                var teamTwoTwo = teamOne_
//                teamTwoTwo = teamTwoTwo.filter { it.healpoints_ !== 0 } as MutableList<AbstractWarrior>
//                println("results T2 ${teamTwoTwo}")
//            }






















//            teamOne_.forEach { warrior: AbstractWarrior ->
//                if (warrior.healpoints_ <= 0)
//                    teamOne_.remove(warrior)
//                println("is Alive team 1 ${teamOne_}")
//                println("HP team 1 ${warrior.healpoints_}")
//
////            army = battle
//            }
//            teamTwo_.forEach { warrior: AbstractWarrior ->
//                if (warrior.healpoints_ <= 0)
//                    teamTwo_.remove(warrior)
//                println("is Alive team 2 ${teamTwo_}")
//                println("HP team 2 ${warrior.healpoints_}")
////            army = battle
//            }
//
////        print ALIVE
//            teamOne_.forEach { warrior: AbstractWarrior ->
//                println("warrior team 1 ${warrior.isDead()} is dead")
//            }
//            teamTwo_.forEach { warrior: AbstractWarrior ->
//                println("warrior team 2 ${warrior.isDead()} is dead")
//            }

//        var iterator = army.iterator()
//        while (iterator.hasNext()) {
//            val item = iterator.next()
//            if (item.healpoints_ <= 0) {
//                army.remove(item)
//        println(army)
// TODO (и вот эту поебень добавил а то нихуя непонятно)

        }

    }


    fun main() {

        var battle = Battle()

        while (!battle.finished_) {
            battle.iterate()
            battle.printState()
        }
    }



