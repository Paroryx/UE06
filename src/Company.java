
public class Company {
    //constants for the design
    final static String LINE_TOP      = "╔═══════════════════════════════════════╗\n";
    final static String SIDE          = "║";
    final static String SEPERATOR     = "╟───────────────────────────────────────╢\n";
    final static String LINE_BOTTOM   = "╚═══════════════════════════════════════╝\n";
    final static String LOGO = "%s%s\t\t Machine \t\t%s\n%s".formatted(LINE_TOP,SIDE,SIDE,SEPERATOR);

    public static void main(String[] args) {
        print(null);
        Machine m1 = buildMachine("Rubber Duck", 20.5, 150);
        print(m1);
        run(m1, 1.0);
        print(m1);
        run(m1,0.1);
        run(m1, 0.02);
        print(m1);
        run(m1, -3);
        run(null,1.5);

        print(null);
        Machine m2 = buildMachine("Pizza Funghi", 180.78, 450);
        print(m2);
        run(m2, 1.0);
        print(m2);
        run(m2,0.1);
        run(m2, 0.02);
        print(m2);
        run(m2, -3);
        run(null,1.5);

        print(null);
        Machine m3 = buildMachine("Pancake", 12.4, 210);
        print(m3);
        run(m3, 1.0);
        print(m3);
        run(m3,0.1);
        run(m3, 0.02);
        print(m3);
        run(m3, -3);
        run(null,1.5);

        print(null);
        Machine m4 = buildMachine("Copper Ingot", 22.5, 850);
        print(m4);
        run(m4, 1.0);
        print(m4);
        run(m4,0.1);
        run(m4, 0.02);
        print(m4);
        run(m4, -3);
        run(null,1.5);

        print(null);
        Machine m5 = buildMachine("T-Shirt", 13.2, 150);
        print(m5);
        run(m5, 1.0);
        print(m5);
        run(m5,0.1);
        run(m5, 0.02);
        print(m5);
        run(m5, -3);
        run(null,1.5);

        print(null);
        Machine m6 = buildMachine("broken machine", 0.0, 0);
        print(m6);
        run(m6, 1.0);
        print(m6);
        run(m6,0.1);
        run(m6, 0.02);
        print(m6);
        run(m6, -3);
        run(null,1.5);

        Factory myFactory = buildFactory(m1,m2,m3,m4,m5,null,m6);
        work(myFactory, 8);
        printServiceCost(myFactory);

        work(null, 1);
        work(buildFactory(), 1);
        Out.println(String.format("Factoy service costs of null factory: %.2f", serviceCosts(null)));
        Out.println(String.format("Factoy service costs of empty factory: %.2f", serviceCosts(buildFactory())));

    }

    private static void printServiceCost(Factory factory){
        Out.println("%s%s Factory Service costs: %.2f \t%s\n%s".formatted(LINE_TOP,SIDE,serviceCosts(factory),SIDE,LINE_BOTTOM));
    }

    private static double serviceCosts(Factory factory){
        double finalServiceCost = 0.0;
        if(factory == null || factory.machines == null || factory.machines.length == 0){
            return finalServiceCost;
        }
        for(Machine m : factory.machines){
            if(m!=null)
                finalServiceCost += m.serviceCost;
        }
        return finalServiceCost;
    }

    private static void work(Factory factory, double hours){
        if(factory == null){
            Out.println("%s%s\t no factory to work \t\t%s\n%s".formatted(LINE_TOP,SIDE,SIDE,LINE_BOTTOM));
        }else if(factory.machines == null || factory.machines.length == 0){
            Out.println("%s%s\t no machines in factory \t%s\n%s".formatted(LINE_TOP,SIDE,SIDE,LINE_BOTTOM));
        }
        else{
            for (int i = 0; i < factory.machines.length; i++) {
                Machine m = factory.machines[i];
                if(m == null){
                    Out.println("%s%s\t no machines at index %d \t%s\n%s".formatted(LINE_TOP,SIDE,i,SIDE,LINE_BOTTOM));
                }else{
                    run(m, hours);
                }
            }
        }
    }

    private static Factory buildFactory(Machine... machines){
        Factory fac = new Factory();
        fac.machines =  machines;
        return fac;
    }

    private static Machine buildMachine(String product, double productionPerHour, double serviceCosts) {
        Machine m = new Machine();
        m.name = product;
        m.productionPerHour = productionPerHour;
        m.serviceCost = serviceCosts;
        return m;
    }


    private static void run(Machine machine, double hours){
        if(machine == null){
            Out.println("%s%s\t no machine to run \t\t%s\n%s".formatted(LINE_TOP,SIDE,SIDE,LINE_BOTTOM));
        }else if(hours<0){
            Out.println("%s%s machines cannot travel back in time \t%s\n%s".formatted(LINE_TOP,SIDE,SIDE,LINE_BOTTOM));
        }else{
        int produced = (int) (machine.productionPerHour*hours);
        machine.nProduced += produced;
        Out.println("%s%s produced %s x %d \t\t%s\n%s\t in %.2f hour(s) \t\t%s\n%s".formatted(LINE_TOP,SIDE,machine.name,produced,SIDE,SIDE,hours,SIDE,LINE_BOTTOM));
        }
    }

    private static void print(Machine machine){
        StringBuilder sb = new StringBuilder();
        sb.append(LOGO);
        if(machine == null){
            sb.append("%s\t no machine to print \t\t%s\n".formatted(SIDE,SIDE));
        }else{
            sb.append("%s\t product name: %s \t%s\n".formatted(SIDE,machine.name,SIDE));
            sb.append("%s\t production per Hour: %.2f \t%s\n".formatted(SIDE,machine.productionPerHour,SIDE));
            sb.append("%s\t has produced: %d \t\t%s\n".formatted(SIDE,machine.nProduced,SIDE));
            sb.append("%s\t service cost: %.2f Euro \t%s\n".formatted(SIDE,machine.serviceCost,SIDE));
        }
        sb.append(LINE_BOTTOM);

        Out.println(sb.toString());
    }
}
