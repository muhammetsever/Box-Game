public class Ring {
    Fighter f1;
    Fighter f2;
    int minWeight;
    int maxWeight;
    int r1;

    public Ring(Fighter f1, Fighter f2, int minWeight, int maxWeight) {
        this.f1 = f1;
        this.f2 = f2;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    public int randomStart(){
        double r = Math.random()*2;
        this.r1 = (int)r ;
        //System.out.println(r1); Control the random start.
        return r1;
    }

    public void run() {
        if (checkWeight()) {
            randomStart();
            while (Resume()) {
                System.out.println("======== YENİ ROUND ===========");
                if(this.r1==1){
                    f2.health = f1.hit(f2);
                    if (isWin()){
                        break;
                    }
                }
                if(this.r1==0){
                    f1.health = f2.hit(f1);
                    if (isWin()){
                        break;
                    }
                }
                printScore();
            }
        }
        else {
            System.out.println("Sporcuların ağırlıkları uyuşmuyor.");
        }
    }

    public boolean Resume(){
        if(this.f1.health > 0 && this.f2.health > 0) return true;
        else {
            return false;
        }
    }

    public boolean checkWeight() {
        System.out.println("Kilo Kontrol Yapılıyor...");
        return (f1.weight >= minWeight && f1.weight <= maxWeight) && (f2.weight >= minWeight && f2.weight <= maxWeight);
    }

    public boolean isWin() {
        if (f1.health == 0) {
            System.out.println("Maçı Kazanan : " + f2.name);
            return true;
        }
        else if (f2.health == 0){
            System.out.println("Maçı Kazanan : " + f1.name);
            return true;
        }

        return false;
    }

    public void printScore() {
        System.out.println("------------");
        System.out.println(f1.name + " Kalan Can \t:" + f1.health);
        System.out.println(f2.name + " Kalan Can \t:" + f2.health);
    }

}
