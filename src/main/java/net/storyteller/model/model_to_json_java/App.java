package net.storyteller.model.model_to_json_java;

import java.io.File;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

public class App 
{
	public static void main( String[] args )	{
		
        Options options = new Options();

        Option fileOption =
            OptionBuilder
                .hasArg(true)    //オプションの後にパラメータが必須か
                .withArgName("filename")    //パラメータ名
                .isRequired(true)    //オプションそのものが必須か
                .withDescription("-f option desc")    //Usage出力用の説明
                .withLongOpt("file")    //オプションの別名（--fileとしても可）
                .create("f");    //fという名前でオプション作成
                
        options.addOption(fileOption);
        options.addOption("l", false, "-l option desc");

        CommandLineParser parser = new PosixParser();
        CommandLine commandLine = null;
        try {
        	commandLine = parser.parse(options, args);
        } catch (ParseException e) {
            HelpFormatter help = new HelpFormatter();
            help.printHelp("CLITest", options, true);
            return;
        }
        String path = null;
        if (commandLine.hasOption("f")) {
            path = commandLine.getOptionValue("f");
            System.out.println("-f option value = " + path);
        }
        if (commandLine.hasOption("l")) {
            System.out.println("-lオプションがあります。");
        }
        File file = new File(path); 
        
		Conversion conversion = new Conversion(file);
	}

}