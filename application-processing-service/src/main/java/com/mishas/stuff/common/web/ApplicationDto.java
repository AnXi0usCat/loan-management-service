package com.mishas.stuff.common.web;


import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class ApplicationDto implements Serializable {

    public ApplicationDto() {
        super();
    }

    public ApplicationDto(
            String id,
            String firstname,
            String surname,
            int loanAmount) {

        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
        this.loanAmount = loanAmount;
    }

    @NotNull
    private String id;
    @NotNull
    private String firstname;
    @NotNull
    private String surname;
    @NotNull
    private int loanAmount;

    public String getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final ApplicationDto other = (ApplicationDto) obj;
        if (firstname == null) {
            if (other.firstname != null)
                return false;
        } else if (!firstname.equals(other.firstname))
            return false;
        return true;
    }

}
