package com.hugofmartin.dragofus.common

sealed class DragodindeFilter {
    object Male:DragodindeFilter()
    object Female: DragodindeFilter()
    object Fertile: DragodindeFilter()
    object NotFertile: DragodindeFilter()
    object Pregnant: DragodindeFilter()
    object Sterile: DragodindeFilter()
}