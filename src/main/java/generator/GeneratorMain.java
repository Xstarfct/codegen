package generator;

import cn.org.rapid_framework.generator.GeneratorFacade;

/**
 * @author badqiu
 * @email badqiu(a)gmail.com
 */

public class GeneratorMain {
    
    /**
     * 请直接修改以下代码调用不同的方法以执行相关生成任务.
     */
    public static void main(String[] args) throws Exception {
        GeneratorFacade g = new GeneratorFacade();
        
        // 设置模板地址
        g.getGenerator().setTemplateRootDir("classpath:template");
        
//        String[] tables = new String[]{"rp_battle_project_relation", "rp_battle_change_member_record", "rp_battle_add_member_record"};
        String[] tables = new String[]{"xsc_member_stage","xsc_course_group","xsc_course_group_area","xsc_course_group_import_record","xsc_course_group_operate_log","xsc_course_group_area_mapping"};
//        String[] tables = new String[]{"cs_course_time_class_type_statistics"};
//        String[] tables = new String[]{"wms_check_delivery_record"};
//        String[] tables = new String[]{"od_order_delivery_item_textbook","od_order_delivery_item_textbook_usertype"};
        
        // 清除已生成的表
        g.deleteByTable(tables);
        
        // 生成模板文件
        g.generateByTable(tables);
        
        // 打开文件夹
//        String os = System.getProperty("os.name");
//        if (os.toLowerCase().startsWith("windows")) {
//            Runtime.getRuntime().exec("cmd.exe /c start " + GeneratorProperties.getRequiredProperty("outRoot"));
//        } else if (os.toLowerCase().startsWith("mac")) {
//            Runtime.getRuntime().exec("open " + GeneratorProperties.getRequiredProperty("outRoot"));
//        }
    }
}
