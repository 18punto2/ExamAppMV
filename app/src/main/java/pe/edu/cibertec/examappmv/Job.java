package pe.edu.cibertec.examappmv;

import com.google.gson.annotations.SerializedName;

public class Job {
    @SerializedName("title")
    private String title;
    @SerializedName("company")
    private String company;
    @SerializedName("description")
    private String description;
    @SerializedName("company_logo")
    private String company_logo;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompany_logo() {
        return company_logo;
    }

    public void setCompany_logo(String company_logo) {
        this.company_logo = company_logo;
    }
}
