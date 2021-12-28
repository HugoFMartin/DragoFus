package com.hugofmartin.dragofus.data.entity

import com.hugofmartin.dragofus.R

enum class Race{
    ROUSSE {
        override val type = "Rousse"
        override val parents = arrayListOf<Race>()
        override fun getGestation(): Int {
            return 48
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_rousse
        }

        override fun getGeneration(): Int {
            return 1
        }
    },
    AMANDE {
        override val type = "Amande"
        override val parents = arrayListOf<Race>()

        override fun getGestation(): Int {
            return 48
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_amande

        }
        override fun getGeneration(): Int {
            return 1
        }
    },
    DOREE {
        override val type = "Dorée"
        override val parents = arrayListOf<Race>()

        override fun getGestation(): Int {
            return 48
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_doree
        }
        override fun getGeneration(): Int {
            return 1
        }
    },
    AMANDE_DOREE {
        override val type = "Amande Dorée"
        override val parents = arrayListOf(DOREE, AMANDE)

        override fun getGestation(): Int {
            return 60
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_amandedoree
        }
        override fun getGeneration(): Int {
            return 2
        }
    },
    ROUSSE_AMANDE {
        override val type = "Rousse-Amande"
        override val parents = arrayListOf(ROUSSE, AMANDE)

        override fun getGestation(): Int {
            return 60
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_amanderousse
        }
        override fun getGeneration(): Int {
            return 2
        }
    },
    ROUSSE_DOREE {
        override val type = "Rousse-Dorée"
        override val parents = arrayListOf(ROUSSE, DOREE)

        override fun getGestation(): Int {
            return 60
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_roussedoree
        }
        override fun getGeneration(): Int {
            return 2
        }
    },
    INDIGO {
        override val type = "Indigo"
        override val parents = arrayListOf(ROUSSE_AMANDE, AMANDE_DOREE)

        override fun getGestation(): Int {
            return 72
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_indigo
        }
        override fun getGeneration(): Int {
            return 3
        }
    },
    EBENE {
        override val type = "Ebène"
        override val parents = arrayListOf(ROUSSE_DOREE, AMANDE_DOREE)

        override fun getGestation(): Int {
            return 72
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_ebene
        }
        override fun getGeneration(): Int {
            return 3
        }
    },
    ROUSSE_INDIGO {
        override val type = "Rousse-Indigo"
        override val parents = arrayListOf(ROUSSE, INDIGO)

        override fun getGestation(): Int {
            return 84
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_rousseindigo
        }
        override fun getGeneration(): Int {
            return 4
        }
    },
    ROUSSE_EBENE {
        override val type = "Rousse-Ebène"
        override val parents = arrayListOf(ROUSSE, EBENE)

        override fun getGestation(): Int {
            return 84
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_rousseebene
        }
        override fun getGeneration(): Int {
            return 4
        }
    },
    AMANDE_INDIGO {
        override val type = "Amande-Indigo"
        override val parents = arrayListOf(AMANDE, INDIGO)

        override fun getGestation(): Int {
            return 84
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_amandeindigo
        }
        override fun getGeneration(): Int {
            return 4
        }
    },
    AMANDE_EBENE {
        override val type = "Amande-Ebène"
        override val parents = arrayListOf(AMANDE, EBENE)

        override fun getGestation(): Int {
            return 84
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_amandeebene
        }
        override fun getGeneration(): Int {
            return 4
        }
    },
    DOREE_INDIGO {
        override val type = "Dorée-Indigo"
        override val parents = arrayListOf(DOREE, INDIGO)

        override fun getGestation(): Int {
            return 84
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_doreeindigo
        }
        override fun getGeneration(): Int {
            return 4
        }
    },
    DOREE_EBENE {
        override val type = "Dorée-Ebène"
        override val parents = arrayListOf(DOREE, EBENE)

        override fun getGestation(): Int {
            return 84
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_doreeebene
        }
        override fun getGeneration(): Int {
            return 4
        }
    },
    INDIGO_EBENE {
        override val type = "Indigo-Ebène"
        override val parents = arrayListOf(INDIGO, EBENE)

        override fun getGestation(): Int {
            return 84
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_indigoebene
        }
        override fun getGeneration(): Int {
            return 4
        }
    },
    POURPRE {
        override val type = "Pourpre"
        override val parents = arrayListOf(ROUSSE_AMANDE, INDIGO_EBENE)

        override fun getGestation(): Int {
            return 96
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_pourpre
        }
        override fun getGeneration(): Int {
            return 5
        }
    },
    ORCHIDEE {
        override val type = "Orchidée"
        override val parents = arrayListOf(ROUSSE_DOREE, INDIGO_EBENE)

        override fun getGestation(): Int {
            return 96
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_orchidee
        }
        override fun getGeneration(): Int {
            return 5
        }
    },
    POURPRE_ROUSSE {
        override val type = "Pourpre-Rousse"
        override val parents = arrayListOf(ROUSSE, POURPRE)

        override fun getGestation(): Int {
            return 108
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_roussepourpre
        }
        override fun getGeneration(): Int {
            return 6
        }
    },
    ORCHIDEE_ROUSSE {
        override val type = "Orchidée-Rousse"
        override val parents = arrayListOf(ROUSSE, ORCHIDEE)

        override fun getGestation(): Int {
            return 108
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_rousseorchidee
        }
        override fun getGeneration(): Int {
            return 6
        }
    },
    AMANDE_POURPRE {
        override val type = "Amande-Pourpre"
        override val parents = arrayListOf(AMANDE, POURPRE)

        override fun getGestation(): Int {
            return 108
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_amandepourpre
        }
        override fun getGeneration(): Int {
            return 6
        }
    },
    AMANDE_ORCHIDEE {
        override val type = "Amande-Orchidée"
        override val parents = arrayListOf(AMANDE, ORCHIDEE)

        override fun getGestation(): Int {
            return 108
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_amandeorchidee
        }
        override fun getGeneration(): Int {
            return 6
        }
    },
    DOREE_POURPRE {
        override val type = "Dorée-Pourpre"
        override val parents = arrayListOf(DOREE, POURPRE)

        override fun getGestation(): Int {
            return 108
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_doreepourpre
        }
        override fun getGeneration(): Int {
            return 6
        }
    },
    DOREE_ORCHIDEE {
        override val type = "Dorée-Orchidée"
        override val parents = arrayListOf(DOREE, ORCHIDEE)

        override fun getGestation(): Int {
            return 108
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_doreeorchidee
        }
        override fun getGeneration(): Int {
            return 6
        }
    },
    INDIGO_POURPRE {
        override val type = "Indigo-Pourpre"
        override val parents = arrayListOf(INDIGO, POURPRE)

        override fun getGestation(): Int {
            return 108
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_indigopourpre
        }
        override fun getGeneration(): Int {
            return 6
        }
    },
    INDIGO_ORCHIDEE {
        override val type = "Indigo-Orchidée"
        override val parents = arrayListOf(INDIGO, ORCHIDEE)

        override fun getGestation(): Int {
            return 108
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_indigoorchidee
        }
        override fun getGeneration(): Int {
            return 6
        }
    },
    EBENE_POURPRE {
        override val type = "Ebène-Pourpre"
        override val parents = arrayListOf(EBENE, POURPRE)

        override fun getGestation(): Int {
            return 108
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_ebenepourpre
        }
        override fun getGeneration(): Int {
            return 6
        }
    },
    EBENE_ORCHIDEE {
        override val type = "Ebène-Orchidée"
        override val parents = arrayListOf(EBENE, POURPRE)

        override fun getGestation(): Int {
            return 108
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_ebeneorchidee
        }
        override fun getGeneration(): Int {
            return 6
        }
    },
    POURPRE_ORCHIDEE {
        override val type = "Pourpre-Orchidée"
        override val parents = arrayListOf(POURPRE, ORCHIDEE)

        override fun getGestation(): Int {
            return 108
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_pourpreorchidee
        }
        override fun getGeneration(): Int {
            return 6
        }
    },
    IVOIRE {
        override val type = "Ivoire"
        override val parents = arrayListOf(INDIGO_POURPRE, POURPRE_ORCHIDEE)

        override fun getGestation(): Int {
            return 120
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_ivoire
        }
        override fun getGeneration(): Int {
            return 7
        }
    },
    TURQUOISE {
        override val type = "Turquoise"
        override val parents = arrayListOf(EBENE_ORCHIDEE, POURPRE_ORCHIDEE)

        override fun getGestation(): Int {
            return 120
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_turquoise
        }
        override fun getGeneration(): Int {
            return 7
        }
    },
    IVOIRE_ROUSSE {
        override val type = "Ivoire-Rousse"
        override val parents = arrayListOf(ROUSSE, IVOIRE)

        override fun getGestation(): Int {
            return 132
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_rousseivoire
        }
        override fun getGeneration(): Int {
            return 8
        }
    },
    TURQUOISE_ROUSSE {
        override val type = "Turquoise-Rousse"
        override val parents = arrayListOf(ROUSSE, TURQUOISE)

        override fun getGestation(): Int {
            return 132
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_rousseturquoise
        }
        override fun getGeneration(): Int {
            return 8
        }
    },
    AMANDE_IVOIRE {
        override val type = "Amande-Ivoire"
        override val parents = arrayListOf(AMANDE, IVOIRE)

        override fun getGestation(): Int {
            return 132
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_amandeivoire
        }
        override fun getGeneration(): Int {
            return 8
        }
    },
    AMANDE_TURQUOISE {
        override val type = "Amande-Turquoise"
        override val parents = arrayListOf(AMANDE, TURQUOISE)

        override fun getGestation(): Int {
            return 132
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_amandeturquoise
        }
        override fun getGeneration(): Int {
            return 8
        }
    },
    DOREE_IVOIRE {
        override val type = "Dorée-Ivoire"
        override val parents = arrayListOf(DOREE, IVOIRE)

        override fun getGestation(): Int {
            return 132
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_doreeivoire
        }
        override fun getGeneration(): Int {
            return 8
        }
    },
    DOREE_TURQUOISE {
        override val type = "Dorée-Turquoise"
        override val parents = arrayListOf(DOREE, TURQUOISE)

        override fun getGestation(): Int {
            return 132
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_doreeturquoise
        }
        override fun getGeneration(): Int {
            return 8
        }
    },
    INDIGO_IVOIRE {
        override val type = "Indigo-Ivoire"
        override val parents = arrayListOf(INDIGO, IVOIRE)

        override fun getGestation(): Int {
            return 132
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_indigoivoire
        }
        override fun getGeneration(): Int {
            return 8
        }
    },
    INDIGO_TURQUOISE {
        override val type = "Indigo-Turquoise"
        override val parents = arrayListOf(INDIGO, TURQUOISE)

        override fun getGestation(): Int {
            return 132
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_indigoturquoise
        }
        override fun getGeneration(): Int {
            return 8
        }
    },
    EBENE_IVOIRE {
        override val type = "Ebène-Ivoire"
        override val parents = arrayListOf(EBENE, IVOIRE)

        override fun getGestation(): Int {
            return 132
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_ebeneivoire
        }
        override fun getGeneration(): Int {
            return 8
        }
    },
    EBENE_TURQUOISE {
        override val type = "Ebène-Turquoise"
        override val parents = arrayListOf(EBENE, TURQUOISE)

        override fun getGestation(): Int {
            return 132
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_ebeneturquoise
        }
        override fun getGeneration(): Int {
            return 8
        }
    },
    POURPRE_IVOIRE {
        override val type = "Pourpre-Ivoire"
        override val parents = arrayListOf(POURPRE, IVOIRE)

        override fun getGestation(): Int {
            return 132
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_pourpreivoire
        }
        override fun getGeneration(): Int {
            return 8
        }
    },
    TURQUOISE_POURPRE {
        override val type = "Turquoise-Pourpre"
        override val parents = arrayListOf(TURQUOISE, POURPRE)

        override fun getGestation(): Int {
            return 132
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_pourpreturquoise
        }
        override fun getGeneration(): Int {
            return 8
        }
    },
    IVOIRE_ORCHIDEE {
        override val type = "Turquoise-Pourpre"
        override val parents = arrayListOf(IVOIRE, ORCHIDEE)

        override fun getGestation(): Int {
            return 132
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_orchideeivoire
        }
        override fun getGeneration(): Int {
            return 8
        }
    },
    TURQUOISE_ORCHIDEE {
        override val type = "Turquoise-Orchidée"
        override val parents = arrayListOf(TURQUOISE, ORCHIDEE)

        override fun getGestation(): Int {
            return 132
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_orchideeturquoise
        }
        override fun getGeneration(): Int {
            return 8
        }
    },
    IVOIRE_TURQUOISE {
        override val type = "Ivoire-Turquoise"
        override val parents = arrayListOf(IVOIRE, TURQUOISE)

        override fun getGestation(): Int {
            return 132
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_ivoireturquoise
        }
        override fun getGeneration(): Int {
            return 8
        }
    },
    EMERAUDE {
        override val type = "Emeraude"
        override val parents = arrayListOf(POURPRE_IVOIRE, IVOIRE_TURQUOISE)

        override fun getGestation(): Int {
            return 144
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_emeraude
        }
        override fun getGeneration(): Int {
            return 9
        }
    },
    PRUNE {
        override val type = "Prune"
        override val parents = arrayListOf(TURQUOISE_ORCHIDEE, IVOIRE_TURQUOISE)

        override fun getGestation(): Int {
            return 144
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_prune
        }
        override fun getGeneration(): Int {
            return 9
        }
    },
    ROUSSE_EMERAUDE {
        override val type = "Rousse-Emeraude"
        override val parents = arrayListOf(ROUSSE, EMERAUDE)

        override fun getGestation(): Int {
            return 156
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_rousseemeraude
        }
        override fun getGeneration(): Int {
            return 10
        }
    },
    ROUSSE_PRUNE {
        override val type = "Rousse-Prune"
        override val parents = arrayListOf(ROUSSE, PRUNE)

        override fun getGestation(): Int {
            return 156
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_rousseprune
        }
        override fun getGeneration(): Int {
            return 10
        }
    },
    AMANDE_EMERAUDE {
        override val type = "Amande-Emeraude"
        override val parents = arrayListOf(AMANDE, EMERAUDE)

        override fun getGestation(): Int {
            return 156
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_amandeemeraude
        }
        override fun getGeneration(): Int {
            return 10
        }
    },
    AMANDE_PRUNE {
        override val type = "Amande-Prune"
        override val parents = arrayListOf(AMANDE, PRUNE)

        override fun getGestation(): Int {
            return 156
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_amandeprune
        }
        override fun getGeneration(): Int {
            return 10
        }
    },
    DOREE_PRUNE {
        override val type = "Dorée-Prune"
        override val parents = arrayListOf(DOREE, PRUNE)

        override fun getGestation(): Int {
            return 156
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_doreeprune
        }
        override fun getGeneration(): Int {
            return 10
        }
    },
    DOREE_EMERAUDE {
        override val type = "Dorée-Emeraude"
        override val parents = arrayListOf(DOREE, EMERAUDE)

        override fun getGestation(): Int {
            return 156
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_doreeemeraude
        }
        override fun getGeneration(): Int {
            return 10
        }
    },
    INDIGO_EMERAUDE {
        override val type = "Indigo-Emeraude"
        override val parents = arrayListOf(INDIGO, EMERAUDE)

        override fun getGestation(): Int {
            return 156
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_indigoemeraude
        }
        override fun getGeneration(): Int {
            return 10
        }
    },
    INDIGO_PRUNE {
        override val type = "Indigo-Prune"
        override val parents = arrayListOf(INDIGO, PRUNE)

        override fun getGestation(): Int {
            return 156
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_indigoprune
        }
        override fun getGeneration(): Int {
            return 10
        }
    },
    EBENE_EMERAUDE {
        override val type = "Ebène-Emeraude"
        override val parents = arrayListOf(EBENE, EMERAUDE)

        override fun getGestation(): Int {
            return 156
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_ebeneemeraude
        }
        override fun getGeneration(): Int {
            return 10
        }
    },
    EBENE_PRUNE {
        override val type = "Ebène-Prune"
        override val parents = arrayListOf(EBENE, PRUNE)

        override fun getGestation(): Int {
            return 156
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_ebeneprune
        }
        override fun getGeneration(): Int {
            return 10
        }
    },
    POURPRE_EMERAUDE {
        override val type = "Pourpre-Emeraude"
        override val parents = arrayListOf(POURPRE, EMERAUDE)

        override fun getGestation(): Int {
            return 156
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_pourpreemeraude
        }
        override fun getGeneration(): Int {
            return 10
        }
    },
    POURPRE_PRUNE {
        override val type = "Pourpre-Prune"
        override val parents = arrayListOf(POURPRE, PRUNE)

        override fun getGestation(): Int {
            return 156
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_pourpreprune
        }
        override fun getGeneration(): Int {
            return 10
        }
    },
    ORCHIDEE_EMERAUDE {
        override val type = "Orchidée-Emeraude"
        override val parents = arrayListOf(ORCHIDEE, EMERAUDE)

        override fun getGestation(): Int {
            return 156
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_orchideeemeraude
        }
        override fun getGeneration(): Int {
            return 10
        }
    },
    ORCHIDEE_PRUNE {
        override val type = "Orchidée-Prune"
        override val parents = arrayListOf(ORCHIDEE, PRUNE)

        override fun getGestation(): Int {
            return 156
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_orchideeprune
        }
        override fun getGeneration(): Int {
            return 10
        }
    },
    IVOIRE_EMERAUDE {
        override val type = "Ivoire-Emeraude"
        override val parents = arrayListOf(IVOIRE, EMERAUDE)

        override fun getGestation(): Int {
            return 156
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_ivoireemeraude
        }
        override fun getGeneration(): Int {
            return 10
        }
    },
    IVOIRE_PRUNE {
        override val type = "Ivoire-Prune"
        override val parents = arrayListOf(IVOIRE, PRUNE)

        override fun getGestation(): Int {
            return 156
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_ivoireprune
        }
        override fun getGeneration(): Int {
            return 10
        }
    },
    TURQUOISE_EMERAUDE {
        override val type = "Turquoise-Emeraude"
        override val parents = arrayListOf(TURQUOISE, EMERAUDE)

        override fun getGestation(): Int {
            return 156
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_turquoiseemeraude
        }
        override fun getGeneration(): Int {
            return 10
        }
    },
    TURQUOISE_PRUNE {
        override val type = "Turquoise-Prune"
        override val parents = arrayListOf(TURQUOISE, PRUNE)

        override fun getGestation(): Int {
            return 156
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_turquoiseprune
        }
        override fun getGeneration(): Int {
            return 10
        }
    },
    EMERAUDE_PRUNE {
        override val type = "Emeraude-Prune"
        override val parents = arrayListOf(EMERAUDE, PRUNE)

        override fun getGestation(): Int {
            return 156
        }

        override fun getImage(): Int {
            return R.drawable.dragodindes_pruneemeraude
        }
        override fun getGeneration(): Int {
            return 10
        }
    };

    abstract val type: String
    abstract val parents: ArrayList<Race>
    abstract fun getGestation(): Int
    abstract fun getImage(): Int
    abstract fun getGeneration(): Int

    companion object {
        fun from(search: String): Race = values().find { it.type == search }!!
        fun from(search: Int): Race = values().find { it.getImage() == search }!!
        fun getChild(male: Dragodinde, female: Dragodinde): Race? =
            values().firstOrNull() { it.parents.contains(male.race) && it.parents.contains(female.race) }
    }
}