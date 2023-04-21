package com.generation.model;

import java.util.HashMap;
import java.util.Map;

public class Module {
    private final String moduleCode;
    private final String moduleName;
    private final String description;

    public Module(String moduleCode, String moduleName, String description) {
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
        this.description = description;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public String getModuleName() {
        return moduleName;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Module{" + "name='" + moduleName + '\'' + '}';
    }
}
