package com.moneymanagementservices.education

import com.moneymanagementservices.database.Education
import javax.inject.Inject

class Repository @Inject constructor(
    private val educationText: EducationText,
    private val localDataSource: LocalDataSource,
    private val mapper: Mapper
) {
    fun showEducationTopics(): List<String> {
        return localDataSource.showEducationTopics()
    }

    fun showEducations(educationTopic: String): List<Education> {
        return  when(educationTopic){
            "Маржинальная торговля" -> educationText.toEntity().marginTrading.map(mapper::toEducation)
            "Фьючерсы и опционы" -> educationText.toEntity().futuresOptions.map(mapper::toEducation)
            "Договора РЕПО" -> educationText.toEntity().REPO.map(mapper::toEducation)
            "Облигации" -> educationText.toEntity().bonds.map(mapper::toEducation)
            "Высокодоходные облигации с низким рейтингом (ВДО)" -> educationText.toEntity().bondsVDO.map(mapper::toEducation)
            "Еврооблигации" -> educationText.toEntity().euroBonds.map(mapper::toEducation)
            "Конвертируемые облигации" -> educationText.toEntity().convertibleBonds.map(mapper::toEducation)
            "Структурные облигации" -> educationText.toEntity().structuredBonds.map(mapper::toEducation)
            "Облигации со структурным доходом" -> educationText.toEntity().structuredIncomeBonds.map(mapper::toEducation)
            "Акции" -> educationText.toEntity().stock.map(mapper::toEducation)
            "Иностранные акции" -> educationText.toEntity().foreignStock.map(mapper::toEducation)
            "Закрытые паевые инвестиционные фонды"  -> educationText.toEntity().zpif.map(mapper::toEducation)
            "Акции не включённые в котировальные списки" -> mutableListOf()
            "Паи и акции ETF, не включенные в котировальные списки, при наличии договора с биржей" -> mutableListOf()
            "Облигации российских эмитентов выпущенные и регулируемые по праву иностранного государства" -> mutableListOf()
            "Облигации иностранных эмитентов" -> mutableListOf()
            else -> mutableListOf()
        }
    }
}