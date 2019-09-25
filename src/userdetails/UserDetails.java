package userdetails;



public class UserDetails {
    private String UserName;
    private String CompanyName;
    private int YearOfJoining;
    private String Email;
    private String Password;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName){
        this.UserName = userName;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName){
        this.CompanyName = companyName;
    }

    public int getYearOfJoining() {
        return YearOfJoining;
    }

    public void setYearOfJoining(int yearOfJoining){
        this.YearOfJoining = yearOfJoining;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getPassword(){
        return Password;
    }

    public void setPassword(String password){
        this.Password = password;
    }
    public void UserDetails(String UserName, String CompanyName, int YearOfJoining) {
        this.UserName = UserName;
        this.CompanyName = CompanyName;
        this.YearOfJoining = YearOfJoining;
        this.Email = createUserEmail();
        this.Password = createUserPassword();
    }

    private String createUserEmail(){
        return  String.format("%s_%d@%s.com", getUserName().toLowerCase(), getYearOfJoining(), getCompanyName().toLowerCase());
    }

    private int generateRandomIntegerFromLimit(int limit){
        return (int) (Math.random() * limit);
    }

    private char generateRandomCharacter(){
        return (char) ('a' + generateRandomIntegerFromLimit(26));
    }

    private String getFirstFiveCharacterFromUserName() {
        if (getUserName().length() < 5){
            StringBuilder pass = new StringBuilder();
            int difference = 5 - getUserName().length();
            pass.append("0".repeat(Math.max(0, difference)));
            return pass.toString();
        }
        else {
            return getUserName().substring(0,5);
        }
    }

    private char getGenerateRandomSpecialSymbol() {
        char[] specialSymbol = {
                '!','@','#','$','%','^','&','*','(',')','_','-','{','}','[',']', '\\','\'', '\"',
                '<','>','?','/',',','.'
        };
        int randomNumber = generateRandomIntegerFromLimit(specialSymbol.length);
        return specialSymbol[randomNumber];
    }

    private String createUserPassword() {
        StringBuilder pass = new StringBuilder();
        pass.append(generateRandomCharacter());
        int j =0;
        while (j<4){
            pass.append((int)(Math.random() * 10));
            j++;
        }
        pass.append(getFirstFiveCharacterFromUserName());
        pass.append(getGenerateRandomSpecialSymbol());
        return pass.toString();
    }

    public static void main(String[] args) {
        UserDetails obj = new UserDetails();
        obj.UserName = "Tushar";
        obj.CompanyName = "GLA";
        obj.YearOfJoining = 2018;

        System.out.println(obj.createUserEmail() + "\n" + obj.createUserPassword());

    }
}