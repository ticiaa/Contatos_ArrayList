package Classes;

    public class Contact implements Comparable<Contact> {
        private String name;
        private String number;
        private int code;
    
        public Contact(String contname, String numbercont, int codecont) {
            number = numbercont;
            name = contname;
            code = codecont;
        }

        private String numberReplace(String number) {
            number = number.replaceAll("(\\d{4})(\\d{4})", "9 $1-$2");
            return number;
        }
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public String getNumber() {
            return numberReplace(number);
        }
    
        public void setNumber(String number) {
    
            if (number.length() == 8) {
                this.number = number;
            } else {
                throw new NumberFormatException("O número deve conter pelo menos 8 digítos.");
            }
        }
    
        public int getCode() {
            return code;
        }
    
        public void setCode(int code) {
            this.code = code;
        }

        @Override
        public int compareTo(Contact c) {
            return getName().compareTo(c.getName());
        }

        @Override
        public String toString() {
            return "Nome: " + name + "   Número: " + number + "   idCode: " + code;
        }
    
    
    }

