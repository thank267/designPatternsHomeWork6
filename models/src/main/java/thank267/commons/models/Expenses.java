package thank267.commons.models;

import lombok.Setter;
import lombok.Getter;

public class Expenses {

    @Getter
    @Setter
    // услуги БТИ
    private ExpensesPaymentEnum bti=ExpensesPaymentEnum.Покупатель;

    @Getter
    @Setter
    // рекламные расходы
    private ExpensesPaymentEnum adv=ExpensesPaymentEnum.Риэлтор;

    @Getter
    @Setter
    // налоговая инспекция
    private ExpensesPaymentEnum tax=ExpensesPaymentEnum.Клиент;

    @Getter
    @Setter
    // коммунальные платежи
    private ExpensesPaymentEnum com=ExpensesPaymentEnum.Клиент;

    @Getter
    @Setter
    // выписка ЕГРН
    private ExpensesPaymentEnum egrn = ExpensesPaymentEnum.Клиент;

}