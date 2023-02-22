import hmv.*
import kotlin.random.Random


fun test0() {
    var a = Ammo.FIRE_BULLET
    var damage1 = a.getCurrentDamage()
    var b = Ammo.ATOMIC_BULLET
    var damage2 = b.getCurrentDamage()
}

object Weapons {
    fun createPistol() = object: AbstractWeapon(7, FireType1.SingleShoot, WareStack<Ammo>()){
    }
    fun createAutomat() = object: AbstractWeapon(7, FireType1.SingleShoot, WareStack<Ammo>()){
    }
    fun createBazooka() = object: AbstractWeapon(7, FireType1.SingleShoot, WareStack<Ammo>()){
    }
    fun createBow() = object: AbstractWeapon(7, FireType1.SingleShoot, WareStack<Ammo>()){
    }


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

        fun iterate() {
//        var player1 = Capitan ()
//        var palyer2 = General ()
//        player1.attack(palyer2)
//        palyer2.attack(player1)
//        println("${player1.isDead()} ${palyer2.isDead()}")
//        finished_ = true
//        return
            // fight
            for (i in 0..teamOne_.size - 1) {
                teamOne_[i].attack(teamTwo_[teamOne_.size - 1 - i])
                for (j in 0..teamOne_.size - 1) {
                    teamOne_[i].attack(teamTwo_[j])
                }
                teamTwo_[i].attack(teamOne_[i])
            }
            finished_ = true


            // remoove killed
            teamOne_

            teamOne_.forEach { warrior: AbstractWarrior ->
                if (warrior.healpoints_ <= 0)
                    teamOne_.remove(warrior)
//            army = battle
            }
            teamTwo_.forEach { warrior: AbstractWarrior ->
                if (warrior.healpoints_ <= 0)
                    teamTwo_.remove(warrior)
//            army = battle
            }

//        print ALIVE
            teamOne_.forEach { warrior: AbstractWarrior ->
                println(warrior.isDead())
            }
            teamTwo_.forEach { warrior: AbstractWarrior ->
                println(warrior.isDead())
            }

//        var iterator = army.iterator()
//        while (iterator.hasNext()) {
//            val item = iterator.next()
//            if (item.healpoints_ <= 0) {
//                army.remove(item)
//        println(army)

        }

    }


    fun main() {

        var battle = Battle()

        while (!battle.finished_) {
            battle.iterate()
        }
    }



