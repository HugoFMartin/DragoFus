package com.hugofmartin.dragofus.data.repository

import com.hugofmartin.dragofus.data.database.DatabaseManager
import com.hugofmartin.dragofus.data.database.dao.DragodindeDao
import com.hugofmartin.dragofus.data.entity.Dragodinde
import kotlinx.coroutines.flow.Flow

interface DragodindeRepository {
    val allDragodindes: Flow<List<Dragodinde>>
    suspend fun addDragodinde(dragodinde: Dragodinde)
    suspend fun deleteDragodinde(dragodindeId: Dragodinde)
    suspend fun makeUnFertile(dragodindeId: Int)
    suspend fun makeFertile(dragodindeId: Int)
    suspend fun makePregnant(femaleDragodindeId: Int)
    suspend fun decrementCoupling(dragodindeId: Int)

    companion object {
        fun newInstance(): DragodindeRepository =
            DragondindeRepositoryImpl(
                DatabaseManager.getInstance().database.dragodindeDao
            )
    }
}

class DragondindeRepositoryImpl(
    private val dragodindeDao: DragodindeDao
) : DragodindeRepository {

    override val allDragodindes: Flow<List<Dragodinde>> = dragodindeDao.getAll()

    override suspend fun addDragodinde(dragodinde: Dragodinde) {
        dragodindeDao.insert(dragodinde)
    }

    override suspend fun deleteDragodinde(dragodindeId: Dragodinde){
        dragodindeDao.delete(dragodindeId)
    }

    override suspend fun makeUnFertile(dragodindeId: Int) {
        dragodindeDao.makeUnFertile(dragodindeId)
    }

    override suspend fun makeFertile(dragodindeId: Int) {
        dragodindeDao.makeFertile(dragodindeId)
    }

    override suspend fun makePregnant(femaleDragodindeId: Int) {
        dragodindeDao.makePregnant(femaleDragodindeId)
    }

    override suspend fun decrementCoupling(dragodindeId: Int) {
        dragodindeDao.decrementCoupling(dragodindeId)
    }
}
