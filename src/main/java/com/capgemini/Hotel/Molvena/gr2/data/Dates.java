package com.capgemini.Hotel.Molvena.gr2.data;

import java.time.LocalDate;

public class Dates {

    private LocalDate desiredPeriodFrom;

    private LocalDate desiredPeriodTill;

    public LocalDate getDesiredPeriodFrom() {
        return desiredPeriodFrom;
    }

    public void setDesiredPeriodFrom(LocalDate desiredPeriodFrom) {
        this.desiredPeriodFrom = desiredPeriodFrom;
    }

    public LocalDate getDesiredPeriodTill() {
        return desiredPeriodTill;
    }

    public void setDesiredPeriodTill(LocalDate desiredPeriodTill) {
        this.desiredPeriodTill = desiredPeriodTill;
    }
}
