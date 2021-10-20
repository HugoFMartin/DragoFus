package com.hugofmartin.dragofus.data.repository

import com.hugofmartin.dragofus.data.database.DatabaseManager
import com.hugofmartin.dragofus.data.database.dao.CouplingDao
import com.hugofmartin.dragofus.data.entity.Coupling
import kotlinx.coroutines.flow.Flow

interface CouplingRepository {
    val allCouplings: Flow<List<Coupling>>
    suspend fun addCoupling(coupling: Coupling)
    fun makeCouplingFinished(couplingId: Int)

    companion object {
        fun newInstance(): CouplingRepository =
            CouplingRepositoryImpl(
                DatabaseManager.getInstance().database.couplingDao
            )
    }
}

class CouplingRepositoryImpl(
    private val couplingDao: CouplingDao
) : CouplingRepository {

    override val allCouplings = couplingDao.getCouplings()

    override suspend fun addCoupling(coupling: Coupling) {
        couplingDao.insert(coupling)
    }

    override fun makeCouplingFinished(couplingId: Int) {
        couplingDao.makeCouplingFinished(couplingId)
    }
}
