package de.ropemc.utils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Mapping {

    private Map<String, String> classes = new HashMap<String, String>();
    private Map<String, Map<String, String>> fields = new HashMap<String, Map<String, String>>();
    private Map<String, Map<String, String>> methods = new HashMap<String, Map<String, String>>();

    public Mapping(File file) {
        this(getStream(file));
    }

    private static InputStream getStream(File file) {
        try {
            return new FileInputStream(file);
        } catch (Exception ex) {
        }
        return null;
    }

    public Mapping(InputStream stream) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(stream));
            String line = null;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("CL:")) {
                    String[] split = line.split(" ");
                    classes.put(split[1].replace('/', '.'), split[2].replace('/', '.'));
                } else if (line.startsWith("FD:")) {
                    String[] split = line.split(" ");
                    String[] orig_split = split[1].split("/");
                    String orig_clazz = "";
                    for (int i = 0; i < orig_split.length - 1; i++) {
                        if (orig_clazz.length() > 0) orig_clazz += ".";
                        orig_clazz += orig_split[i];
                    }
                    String orig_field = orig_split[orig_split.length - 1];
                    String[] new_split = split[2].split("/");
                    String new_field = new_split[new_split.length - 1];
                    Map<String, String> fm = null;
                    if (fields.containsKey(orig_clazz)) {
                        fm = fields.get(orig_clazz);
                    } else {
                        fm = new HashMap<String, String>();
                    }
                    fm.put(orig_field, new_field);
                    fields.put(orig_clazz, fm);
                } else if (line.startsWith("MD:")) {
                    String[] split = line.split(" ");
                    String[] orig_split = split[1].split("/");
                    String orig_clazz = "";
                    for (int i = 0; i < orig_split.length - 1; i++) {
                        if (orig_clazz.length() > 0) orig_clazz += ".";
                        orig_clazz += orig_split[i];
                    }
                    String orig_method = orig_split[orig_split.length - 1];
                    String[] new_split = split[3].split("/");
                    String new_method = new_split[new_split.length - 1];
                    Map<String, String> mm = null;
                    if (methods.containsKey(orig_clazz)) {
                        mm = methods.get(orig_clazz);
                    } else {
                        mm = new HashMap<String, String>();
                    }
                    mm.put(orig_method, new_method);
                    methods.put(orig_clazz, mm);
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getClassName(String clazz) {
        if (classes.containsKey(clazz))
            return classes.get(clazz);
        return null;
    }

    public String getFieldName(String clazz, String field) {
        if (fields.containsKey(clazz)) {
            Map<String, String> fm = fields.get(clazz);
            if (fm.containsKey(field)) {
                return fm.get(field);
            }
        }
        return null;
    }

    public String getMethodName(String clazz, String method) {
        if (method.equals("toString")) return method;
        if (method.equals("equals")) return method;
        if (methods.containsKey(clazz)) {
            Map<String, String> mm = methods.get(clazz);
            if (mm.containsKey(method)) {
                return mm.get(method);
            }
        }
        return null;
    }

    public Map<String, String> getClasses() {
        return classes;
    }
}
