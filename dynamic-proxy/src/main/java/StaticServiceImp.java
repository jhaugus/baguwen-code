public class StaticServiceImp implements StaticService{
    @Override
    public void staticPerformTask() {
        System.out.println("StaticServiceImp.staticPerformTask");
    }

    @Override
    public void staticPerformTask2() {
        System.out.println("StaticServiceImp.staticPerformTask2");
    }
}
