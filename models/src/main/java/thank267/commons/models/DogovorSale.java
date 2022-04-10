package thank267.commons.models;

import lombok.Setter;

import java.util.List;

import lombok.Getter;

public class DogovorSale {

    @Getter
    @Setter
    // Дополнительные условия
    private List<String> additionalCondition;

    @Getter
    @Setter
    // вознаграждение
    private Award award;
    
    @Getter
    @Setter
    // срок договора
    private Event сontractTerm;

    @Getter
    @Setter
    // Пртокол разногласий
    private List<String> discrepancyReport;

    @Getter
    @Setter
    // Исполнитель по договору
    private Payer executor;

    @Getter
    @Setter
    // номер договора
    private Integer number;

    @Getter
    @Setter
    // Собственники 
    private List<Person> owners;

    @Getter
    @Setter
    // контакт по договору
    private Person person;

    @Getter
    @Setter
    // стоимость продажи объекта
    private Price price;

    @Getter
    @Setter
    // Объект по договору
    private Property property;

    @Getter
    @Setter
    // Документы онования/подтверждения
    private List<Right> rights;
    
    @Getter
    @Setter
    // Срок осовобождения квартиры
    private Duration termOfObjectRelease;

    @Getter
    @Setter
    // Оплата расходов
    private Expenses expenses;

    @Getter
    @Setter
    // Оплата нотариуса
    private NotaryPaymentEnum notary = NotaryPaymentEnum.Сторона;

    @Getter
    @Setter
    // Срок выдачи доверенности
    private Duration TermIssuingAttorney = new Duration(6, DurationEnum.Месяц);

    @Getter
    @Setter
    // Возможность передоверия
    private AttorneyEnum PossibilityReTrust = AttorneyEnum.With;

}