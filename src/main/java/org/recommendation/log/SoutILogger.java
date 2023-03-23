package org.recommendation.log;

public class SoutILogger implements ILogger {
    @Override
    public void info(final String... info) {
        printer(info);
    }

    @Override
    public void warn(final String... warning) {
        printer(warning);
    }

    @Override
    public void error(final String context, final Exception ex) {
        System.out.println("Inside "+ context+ "getting exception: "+ex.toString());
    }

    @Override
    public void eror(final String... error) {
        printer(error);
    }

    private void printer(String... strings){
        for (String item:strings)
            System.out.print(item);
        System.out.println();
    }

}
