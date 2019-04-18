 class person {

    protected double salary;
    protected int date;
    protected String name;

    public static void main(String[] args) {

        person masPers[] = new person [2];
        chief masChief[] = new chief [2];

        masPers[0] = new person(19041998,50000, "MARIA");
        masPers[1] = new person(22111989,20000, "ELENA");



        masChief[0] = new chief(18091994,45000, "VLADIMIR",0.1);
        masChief[1] = new chief(30071999,50000, "JEKA",0.3);


        System.out.println(masPers[0].getName());            //1 служащий
        System.out.println(masPers[0].getDate());
        System.out.println(masPers[0].getSalary());

        System.out.println();


        System.out.println(masPers[1].getName());            //2 служащий
        System.out.println(masPers[1].getDate());
        System.out.println(masPers[1].getSalary());

        System.out.println();
        //1 начальник
        System.out.println(masChief[0].getName());
        System.out.println(masChief[0].getDate());
        System.out.println(masChief[0].getSalary());

        System.out.println();

        System.out.println(masChief[1].getName());         //2 начальник
        System.out.println(masChief[1].getDate());
        System.out.println(masChief[1].getSalary());

        masPers[0].raisSalary(20);
        masChief[1].raisSalary(30);      // поднимаем зарплату  2 начальнику и 1 служащему

        System.out.println();

        System.out.println(masPers[0].getName());            //1 служащий
        System.out.println(masPers[0].getDate());
        System.out.println(masPers[0].getSalary());



        System.out.println();

        System.out.println(masChief[1].getName());         //2 начальник
        System.out.println(masChief[1].getDate());
        System.out.println(masChief[1].getSalary());





    }

    public person (int data , double salary, String name)
    {
        this.date = data;
        this.salary = salary;
        this.name = name;



    }
    public int getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
    public void raisSalary(double percent)
    {
        salary += (percent / 100)*salary;
    }

}

class chief extends person
{

    private double k;

    chief (int data , double salary, String name, double k)
    {
        super(data, salary, name);
        // this.date = data;
        //this.salary = salary;
        // this.name = name;
        this.k = k;

    }

    public void raisSalary(double percent)
    {
        salary += (((percent+(k*percent))/100)*salary);
    }


}
