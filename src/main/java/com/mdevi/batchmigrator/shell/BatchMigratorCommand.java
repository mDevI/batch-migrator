package com.mdevi.batchmigrator.shell;

import org.springframework.batch.core.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class BatchMigratorCommand {

    @Autowired
    public Job importUserJob;


    @ShellMethod(value = "Migrate to sql from csv file.", key = "csv2sql", group = "Migration")
    public void runMigration() {
        System.out.println("Migration complete");
    }
}
