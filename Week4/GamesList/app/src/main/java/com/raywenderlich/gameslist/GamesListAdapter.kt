package com.raywenderlich.gameslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import androidx.recyclerview.widget.RecyclerView

//TODO add input game (parcels)
class GamesListAdapter(val clickListener: GameDetailsClickListener) : RecyclerView.Adapter<GamesListViewHolder>() {

    val zeldaBOTW = Game("The Legend of Zelda: Breath of the Wild",
        "March 3, 2017",
        "Nintendo EPD",
        "Nintendo",
        "Breath of the Wild takes place at the end of the Zelda timeline in the kingdom of Hyrule. 10,000 years before the beginning of the game, the evil Calamity Ganon threatens Hyrule, but he is defeated by a princess with the blood of the goddess and with the help of her appointed knight. Hyrule matured into an advanced civilization, protected by four enormous animalistic machines called the Divine Beasts and an army of autonomous weapons called Guardians. Upon Ganon's return, four great warriors were given the title of Champion, and each piloted one of the Divine Beasts to weaken Ganon while the princess and knight fought him so she could seal him away. 9,900 years later, the kingdom of Hyrule had devolved to a medieval state. Reading their ancestors' prophecies, the Hylians recognized the signs of Ganon's return and excavated the Divine Beasts and Guardians. During this time, Zelda trained vigorously to awaken the sealing magic needed to defeat Ganon. The champions of Hyrule's races—Daruk, warrior of the mountainous Goron; Mipha, princess of the aquatic Zora; Revali, archer of the birdlike Rito; and Urbosa, chief of the desert-dwelling Gerudo—assembled to pilot the Divine Beasts (Vah Rudania, Vah Ruta, Vah Medoh, and Vah Naboris respectively,) while the current Zelda and Link battled Ganon.[23] However, Ganon possessed the Guardians and Divine Beasts, turning them against Hyrule. King Rhoam and the Champions were killed, the castle town was destroyed, and Link was gravely wounded.[24] Zelda took Link to safety, hid the Master Sword, and used her magic to trap Ganon in Hyrule Castle. 100 years after that, an amnesiac Link awakens in Hyrule. He meets an old man, who reveals himself as the spirit of King Rhoam. Rhoam explains that Ganon, sealed in Hyrule Castle, has grown strong; he pleads for Link to defeat Ganon before he breaks free and destroys the world.",
        "Nintendo Switch & Wii U",
        R.drawable.zelda)

    val lastOfUs = Game("The Last of Us",
        "June 14, 2013",
        "Naughty Dog",
        "Sony Computer Entertainment",
        "In 2013, an outbreak of a mutant Cordyceps fungus ravages the United States, transforming its human hosts into aggressive creatures known as the Infected. In the suburbs of Austin, Texas, Joel (Troy Baker) flees the chaos with his brother Tommy (Jeffrey Pierce) and daughter Sarah (Hana Hayes). As they flee, Sarah is shot by a soldier and dies in Joel's arms. Twenty years later, civilization has been decimated by the infection. Survivors live in heavily policed quarantine zones, independent settlements, and nomadic groups. Joel works as a smuggler with his partner Tess (Annie Wersching) in the quarantine zone in the North End of Boston, Massachusetts. They hunt down Robert (Robin Atkin Downes), a black-market dealer, to recover a stolen weapons cache. Before Tess kills him, Robert reveals that he traded the cache with the Fireflies, a rebel militia opposing the quarantine zone authorities.",
        "PlayStation 3 & 4",
        R.drawable.lastofus)

    val animalCrossing = Game("Animal Crossing: New Horizons",
        "March 20, 2020",
        "Nintendo EPD",
        "Nintendo",
        "Animal Crossing: New Horizons is a 2020 life simulation video game developed and published by Nintendo for the Nintendo Switch. It is the fifth main series title in the Animal Crossing series. New Horizons was released in all regions on March 20, 2020. In New Horizons, the player assumes the role of a customizable character who moves to a deserted island after purchasing a package from Tom Nook, a tanuki character who has appeared in every entry in the Animal Crossing series. Taking place in real-time, the player can explore the island in a nonlinear fashion, gathering and crafting items, catching insects and fish, and developing the island into a community of anthropomorphic animals.",
        "Nintendo Switch",
        R.drawable.animalcrossing)

    val deathStranding = Game("Death Stranding",
        "November 8, 2019",
        "Kojima Productions",
        "Sony Computer Entertainment",
        "The game is set in an apocalyptic United States, where a cataclysmic event known as the \"Death Stranding\" caused \"Beached Things\" (\"BTs\")—invisible creatures originating from the \"Beach\", lands thought to be unique to each person that are typically visited during near death experiences and are said to be the link to the afterlife—to begin roaming the Earth. BTs cause explosions known as \"voidouts\" when they consume the dead by necrosis, and produce rain known as \"Timefall\" that rapidly ages and deteriorates whatever it hits. These events damaged the country's infrastructure, leading its remaining population to confine themselves to remote colonies known as \"Knot Cities,\" which form the remaining \"United Cities of America\".",
        "PlayStation 4",
        R.drawable.deathstranding)

    val spiderMan = Game( "Marvel's Spider-Man",
        "September 7, 2018",
        "Insomniac Games",
        "Sony Interactive Entertainment",
        "Spider-Man features a large ensemble cast of characters drawn from the history of Spider-Man comics. Peter Parker (voiced by Yuri Lowenthal) is a 23-year-old research assistant, who gains superhuman abilities after being bitten by a genetically-modified spider. Assuming a secret identity as the superhero Spider-Man, Peter uses these abilities to protect the residents of New York City. Eight years into his superhero career, Peter has become an experienced crime fighter but struggles to balance his superhero and personal lives. Peter is assisted by Daily Bugle reporter Mary Jane Watson (Laura Bailey), his ex-girlfriend, and NYPD Captain Yuri Watanabe (Tara Platt). In his civilian life, Peter is supported by his Aunt May (Nancy Linari) who volunteers at the F.E.A.S.T. homeless shelter run by philanthropist Martin Li (Stephen Oyoung). Peter is employed by his friend and mentor, the respected scientist Dr. Otto Octavius (William Salyers).",
        "PlayStation 4",
        R.drawable.spiderman)

    private val gamesList = mutableListOf<Game>(zeldaBOTW, lastOfUs, spiderMan, deathStranding, animalCrossing)

    //interface for item click listener
    interface GameDetailsClickListener {
        fun gameClicked(game: Game) //TODO add input game
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesListViewHolder {
        //creates view using the game_list_view_holder layout
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.game_list_view_holder, parent, false)
        return GamesListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return gamesList.size
    }

    override fun onBindViewHolder(holder: GamesListViewHolder, position: Int) {

        holder.gameImageView.setImageResource(gamesList[position].poster)
        // buildSpannedString used to make the game title bold
        holder.gameDescription.text = buildSpannedString {
            bold { append(gamesList[position].title + "\n") }
            append(gamesList[position].plataform)
        }
        // adds a binder for a click on the game
        holder.itemView.setOnClickListener{
            clickListener.gameClicked(gamesList[position])
        }
    }
}