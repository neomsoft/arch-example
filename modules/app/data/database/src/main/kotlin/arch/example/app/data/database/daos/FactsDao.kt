package arch.example.app.data.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import arch.example.app.data.database.entities.FactEntity

@Dao
internal interface FactsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: FactEntity)

    @Query("SELECT * FROM ${FactEntity.Table.TABLE_NAME}")
    suspend fun fats(): List<FactEntity>
}