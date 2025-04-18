package com.moneymanagementservices.questions

import com.google.gson.Gson
import com.moneymanagementservices.questions.models.EntityList
import javax.inject.Inject

class QuestionsList @Inject constructor() {

    fun toEntity(): EntityList {
        val gsonAdapter = Gson().getAdapter(EntityList::class.java)
        return gsonAdapter.fromJson(questions)
    }

    private val questions =
        """ 
            {
                "questions": [
                    {
                        "theme": "Маржинальная торговля",
                        "question": "Что такое маржинальная торговля",
                        "one": "",
                        "two": "",
                        "three": "",
                        "four": "",
                        "control": "Торговля на заемные средства, которые инвестор получает от брокера"
                    },
                    {
                        "theme": "Маржинальная торговля",
                        "question": "С какой целью брокер использует ставки риска в связи с маржинальными / необеспеченными сделками?",
                        "one":"Для расчета размера начальной или минимальной маржи",
                        "two":"Законодательство не требует от брокера использовать ставки риска",
                        "three":"Для расчёта начальной или минимальной маржи в отношении неквалифицированных иевесторов. Для квалифицированных инвесторов ставки риска могут брокером не использоваться",
                        "four":"Для расчёта показателей финансовой устойчивости брокера. В отношениях с клиентами брокер не обязан использовать ставки риска.",
                        "control": "Для расчета размера начальной или минимальной маржи"
                    },
                    {
                        "theme": "Маржинальная торговля",
                        "question": "Может ли взиматься плата за использование средств, предоставленных брокером при маржинальной торговле?",
                        "one": "Может в любом случае.",
                        "two": "Может, если это предусмотрено договором с брокером.",
                        "three": "Может, если брокер не отказался от получения такой платы при заключении брокерского договора.",
                        "four": "Не может, если маржинальная торговля осуществляется только на бирже",
                        "control": "Может, если это предусмотрено договором с брокером."
                    },
                    {
                        "theme": "Маржинальная торговля",
                        "question": "Если Вы при инвестировании совершаете маржинальные/необеспеченные сделки, как правило, размер возможных убытков:",
                        "one": "меньше, чем при торговле только на собственные средства",
                        "two": "больше, чем при торговле только на собственные средства",
                        "three": "может быть как больше, так и меньше, чем при торговле только на собственные средства",
                        "four": "может быть как больше, чем при торговле на собственные средства, так и не зависеть от того, совершаете ли Вы маржинальные / необеспеченные сделки",
                        "control": "больше, чем при торговле только на собственные средства"
                    },
                    {
                        "theme": "Маржинальная торговля",
                        "question": "При покупке ценных бумаг Вы использовали 50% собственных и 50% заемных средств от брокера. Через некоторое время Вы продали ценные бумаги на 5% дороже. Какой Ваш финансовый результат (без учета налогов)?",
                        "one": "Ни один из ответов не является правильным.",
                        "two": "",
                        "three": "Привлечение заёмных средств в размере не более суммы используемых собственных средств, как правило, является бесплатным, поэтому финансовый результат равен 10% от суммы собственных средств.",
                        "four": "Финансовый результат невозможно определить по представленной информации, поскольку на него также влияют комиссии брокера за совершение сделок и стоимость заемных средств от брокера.",
                        "control": "Финансовый результат невозможно определить по представленной информации, поскольку на него также влияют комиссии брокера за совершение сделок и стоимость заемных средств от брокера."
                    },
                    {
                        "theme": "Маржинальная торговля",
                        "question": "Выберите верное утверждение в отношении возможных убытков при торговле с использованием необеспеченных / маржинальных сделок.",
                        "one": "Убытки по каждому инструменту ограничены ставкой риска соответствующего инструмента, то есть можно по соответствующему финансовому инструменту потерять не больше доли, равной соответствующей ставке риска.",
                        "two": "Ни один из ответов не является правильным",
                        "three": "При заключении необеспеченных / маржинальных сделок по продаже ценных бумаг размер убытков не ограничен и может превышать объем средств, которые находятся на брокерском счете.",
                        "four": "При заключении необеспеченных / маржинальных сделок по продаже ценных бумаг в интересах неквалифицированного инвестора размер убытков ограничен величиной суммы активов, внесенных клиентом на брокерский счет.",
                        "control": "При заключении необеспеченных / маржинальных сделок по продаже ценных бумаг размер убытков не ограничен и может превышать объем средств, которые находятся на брокерском счете."
                    },
                    {
                        "theme": "Маржинальная торговля",
                        "question": "Укажите верное утверждение в отношении маржинального займа.",
                        "one": "Условия использования маржинального займа определяются брокерским договором.",
                        "two": "Максимальная плата за использование маржинального займа ограничена законодательно.",
                        "three": "Ни один из ответов не является верным.",
                        "four": "Срок маржинального займа фиксирован, и брокер не может потребовать возврат займа раньше этого срока.",
                        "control": "Условия использования маржинального займа определяются брокерским договором."
                    },
                    {
                        "theme": "Маржинальная торговля",
                        "question": "Вы являетесь неквалифицированным инвестором и совершаете сделки с использованием заемных средств. Выберите верное утверждение.",
                        "one": "Убыток в размере, не превышающем 1,4 млн рублей, полученный в результате использования заёмных средств, будет возмещён вам за счёт гарантийного фонда.",
                        "two": "Вы можете совершать сделки с использованием заёмных средств только с ценными бумагами, входящими в котировальный список первого уровня.",
                        "three": "При маржинальной торговле Вы можете потратить больше средств, чем стоимость активов, переданных Вами брокеру, при этом возмещение понесенных убытков за счет гарантийного фонда законодательством не предусмотрено.",
                        "four": "Ни один из ответов не является верным.",
                        "control": "При маржинальной торговле Вы можете потратить больше средств, чем стоимость активов, переданных Вами брокеру, при этом возмещение понесенных убытков за счет гарантийного фонда законодательством не предусмотрено."
                    },
                    {
                        "theme": "Маржинальная торговля",
                        "question": "В каком случае брокер может принудительно закрыть позицию клиента при наличии ранее заключенных маржинальных / необеспеченных сделок?",
                        "one": "В любой момент времени по усмотрению брокера.",
                        "two": "Брокер не вправе закрывать позицию клиента, только клиент управляет закрытием позиции.",
                        "three": "В случае недостаточности обеспечения по маржинальной / необеспеченной позиции.",
                        "four": "При предъявлении соответсвующего требования со стороны Банка России.",
                        "control": "В случае недостаточности обеспечения по маржинальной / необеспеченной позиции."
                    },
                    {
                        "theme": "Маржинальная торговля",
                        "question": "Стоимость Вашего портфеля стала ниже величины минимальной маржи. Выберите верное утверждение.",
                        "one": "Вы можете довнести средства либо совершить сделки, которые увеличат стоимость Вашего портфеля до величины выше минимальной маржи. В противном случае, если стоимость портфеля будет оставаться ниже минимальной маржи, брокер должен принудительно закрыть некоторые Ваши позиции.",
                        "two": "Брокер уведомит Вас о данной ситуации и в течение ближайшего часа обязан закрыть некоторые Ваши позиции принудительно.",
                        "three": "Вы должны совершить сделки, в результате которых минимальная маржа станет равна нулю. Если Вы этого не сделаете, брокер совершит такие сделки принудительно.",
                        "four": "Ни один из ответов не является правильным.",
                        "control": "Вы можете довнести средства либо совершить сделки, которые увеличат стоимость Вашего портфеля до величины выше минимальной маржи. В противном случае, если стоимость портфеля будет оставаться ниже минимальной маржи, брокер должен принудительно закрыть некоторые Ваши позиции."
                    },
                    {
                        "theme": "Маржинальная торговля",
                        "question": "Стоимость Вашего портфеля стала ниже величины начальной маржи. Выберите верное утверждение.",
                        "one": "Вы не можете совершать сделки, увеличивающие абсолютный размер разности между стоимостью портфеля и начальной маржой.",
                        "two": "",
                        "three": "",
                        "four": "",
                        "control": "Вы не можете совершать сделки, увеличивающие абсолютный размер разности между стоимостью портфеля и начальной маржой."
                    },
                    {
                        "theme": "Заключение договоров РЕПО",
                        "question": "Если Вы продали ценную бумагу по первой части договора репо, по второй части такого договора репо Вы:",
                        "one": "будете покупать такую же ценную бумагу",
                        "two": "будете продавать такую же ценную бумагу.",
                        "three": "только уплатите доход по ценной бумаге, которая продана по договору репо.",
                        "four": "ни один из ответов не является правильным.",
                        "control": "будете покупать такую же ценную бумагу"
                    },
                    {
                        "theme": "Заключение договоров РЕПО",
                        "question": "Если по первой части репо Вы купили ценную бумагу, по второй части репо Вы:",
                        "one": "Будете продавать такую же ценную бумагу.",
                        "two": "Ни один из ответов не является верным.",
                        "three": "Получили денежные средства по первой части договора репо, которые при исполнении обязательств по второй части этого договора нужно вернуть, как правило, с процентами, исчисленными по ставке репо.",
                        "four": "Можете по своему выбору получить как такую же, так и другую ценную бумагу по второй части договора репо.",
                        "control": "Будете продавать такую же ценную бумагу."
                    },
                    {
                        "theme": "Заключение договоров РЕПО",
                        "question": "Если Вы продали ценную бумагу по первой части договора репо, это означает, что Вы..",
                        "one": "",
                        "two": "",
                        "three": "",
                        "four": "",
                        "control": ""
                    },
                    {
                        "theme": "Заключение договоров РЕПО",
                        "question": "Переоценка по договору репо",
                        "one": "Является обязательным условием любого договора репо.",
                        "two": "Может проводиться в целях снижения риска неисполнения обязательств по второй части договора репо.",
                        "three": "Может проводиться в целях снижения риска дефолта эмитента.",
                        "four": "Проводится только при заключении договоров репо с акциями.",
                        "control": "Может проводиться в целях снижения риска неисполнения обязательств по второй части договора репо"
                    },
                    {
                        "theme": "Заключение договоров РЕПО",
                        "question": "Вы являетесь покупателем по первой части договора репо. По ценным бумагам, которые Вы получили по договору репо, осуществлена выплата денежных средств или передано иное имущество, в том числе в виде дивидендов или процентов (доход). В каком случае Вы обязаны передать сумму такого дохода продавцу по договору репо?",
                        "one": "В любом случае, даже если Вы этот доход фактически не получили",
                        "two": "Вы не обязаны передавать продавцу по договору репо такой доход, если это предусмотрено условиями договора репо.",
                        "three": "Только если Вы являетесь эмитентом ценных бумаг, приобретенных по договору репо.",
                        "four": "Ни один из ответов не является правильным.",
                        "control": "В любом случае, даже если Вы этот доход фактически не получили"
                    },
                    {
                        "theme": "Заключение договоров РЕПО",
                        "question": "Если Вы являетесь продавцом по договору репо, требование о перечислении маржинального взноса может Вам поступить:",
                        "one": "",
                        "two": "",
                        "three": "",
                        "four": "",
                        "control": "Если снизилась стоимость ценных бумаг, переданных Вами по договору репо"
                    },
                    
                    
                    {
                        "theme": "Заключение договоров РЕПО",
                        "question": "Продавец передал в собственность покупателя ценные бумаги по договору репо (в случае отсутствия в договоре оговорки о возможности возврата иного количества ценных бумаг). Риск невозврата ценных бумаг, переданных по первой части договора репо, для продавца может реализоваться:",
                        "one": "При неисполнении покупателем своих обязательств по договору репо, а также при погашении ценных бумаг.",
                        "two": "Только в случае, если покупатель не предоставил обеспечение продавцу.",
                        "three": "Только при неисполнении покупателем своих обязательств по договору репо в случае, если по такому договору репо производилась переоценка.",
                        "four": "Только при увеличении цены ценных бумаг, преданных покупателю по договору репо, на дату исполнения второй части договора репо, если цена увеличилась более, чем на 100 % по сравнению с ценой на дату исполнения первой части договора репо.",
                        "control": "При неисполнении покупателем своих обязательств по договору репо, а также при погашении ценных бумаг."
                    },

                    {
                        "theme": "Заключение договоров РЕПО",
                        "question": "Если Вы являетесь продавцом по договору репо, требование о перечислении маржинального взноса может Вам поступить:",
                        "one": "Ни при каких обстоятельствах, поскольку договор РЕПО гарантирует полную защиту продавца от убытков.",
                        "two": "Если регулятор финансового рынка (например, Банк России) примет соответствующее решение.",
                        "three": "",
                        "four": "Если снизилась стоимость ценных бумаг, переданных Вами по договору репо",
                        "control": "Если снизилась стоимость ценных бумаг, переданных Вами по договору репо"
                    },
                    {
                        "theme": "Заключение договоров РЕПО",
                        "question": "Если Вы продали по первой части договора репо ценные бумаги, а покупатель по договору репо фактически получил доход (дивиденды или купон), то:",
                        "one": "Покупатель должен перечислить сумму такого дохода Вам, если это предусмотрено заключенным между вами договором.",
                        "two": "Покупатель должен перечислить сумму такого дохода Вам.",
                        "three": "Покупатель должен перечислить сумму такого дохода государству.",
                        "four": "Сумма такого дохода остается у покупателя.",
                        "control": "Покупатель должен перечислить сумму такого дохода Вам"
                    },
                    {
                        "theme": "Заключение договоров РЕПО",
                        "question": "Что из перечисленного не может быть передано по договору репо?",
                        "one": "Паи / акции инвестиционного фонда, управляющая компания которого является российской компанией",
                        "two": "Акции иностранной компании",
                        "three": "Паи / акции фонда ETF",
                        "four": "Фьючерсы",
                        "control": ""
                    },
                    {
                        "theme": "Заключение договоров РЕПО",
                        "question": "Покупатель по договору репо передал продавцу по договору репо денежные средства. Риск невозврата денежных средств, переданных по первой части договора репо, для покупателя может реализоваться:",
                        "one": "при неисполнении продавцом своих обязательств",
                        "two": "в данном случае риска нет, поскольку, согласно требованиям Банка России, продавец по договору репо при надлежащем его исполнении обязан компенсировать стоимость ценных бумаг по такому договору, которая всегда привышает сумму переданных по первой части репо денежных средств",
                        "three": "указанный риск по договору репо отсутствует",
                        "four": "только при банкротстве продавца",
                        "control": "При неисполнении продавцом своих обязательств"
                    },
                    {
                        "theme": "Заключение договоров РЕПО",
                        "question": "Если Вы являетесь покупателем по первой части договора репо, требование о перечислении маржинального взноса в рамках этого договора может Вам поступить:",
                        "one": "",
                        "two": "",
                        "three": "",
                        "four": "",
                        "control": ""
                    },
                    {
                        "theme": "Заключение договоров РЕПО",
                        "question": "Продавец передал в собственность покупателя ценные бумаги по договору репо (в случае отсутствия в договоре оговорки о возможности возврата иного количества ценных бумаг). Риск невозврата ценных бумаг, переданных по первой части договора репо, для продавца может реализоваться:",
                        "one": "",
                        "two": "В случае дефолта (банкротства) покупателя ценных бумаг (брокера).",
                        "three": "",
                        "four": "",
                        "control": "В случае дефолта (банкротства) покупателя ценных бумаг (брокера)."
                    },
                    {
                        "theme": "Заключение договоров РЕПО",
                        "question": "Покупатель по договору репо передал продавцу по договору репо денежные средства. Риск невозврата денежных средств, переданных по первой части договора репо, для покупателя может реализоваться:",
                        "one": "",
                        "two": "",
                        "three": "",
                        "four": "",
                        "control": ""
                    }
                ]        
            }
        """.trimIndent()
}