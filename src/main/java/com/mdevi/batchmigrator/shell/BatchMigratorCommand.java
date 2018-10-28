package com.mdevi.batchmigrator.shell;

import com.mdevi.batchmigrator.repository.PersonRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class BatchMigratorCommand {

    @Autowired
    public Job importUserJob;

    @Autowired
    public JobLauncher jobLauncher;

    @Autowired
    public PersonRepository repository;

    @ShellMethod(value = "Migrate to sql from mongo.", key = "sql2mongo", group = "Migration")
    public void runMigration() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        jobLauncher.run(importUserJob, new JobParameters());
        System.out.println("Migration complete!");
    }


    @ShellMethod(value = "Show all records number in H2 database", key = "showRecords", group = "Migration")
    public void showDbRecordsCount() {
        System.out.println(repository.count());
    }
}
