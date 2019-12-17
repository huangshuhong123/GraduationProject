package com.zhku.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MergeVideoMp3 {

	private String ffmpegEXE;
	
	public MergeVideoMp3(String ffmpegEXE) {
		super();
		this.ffmpegEXE = ffmpegEXE;
	}
	
	public void convertor1(String videoInputPath1, String videoInputPath2) throws Exception {
//		ffmpeg.exe -i 苏州大裤衩.mp4 -i bgm.mp3 -t 7 -y 新的视频.mp4
		List<String> command = new ArrayList<>();
		command.add(ffmpegEXE);

		command.add("-i");
		command.add(videoInputPath1);

		command.add("-c:v copy");

		command.add("-an");
		command.add(videoInputPath2);

		for (String c : command) {
			System.out.print(c + " ");
		}
		StringBuilder sb = new StringBuilder();
		for (String c : command) {
			sb.append(c + " ");
		}
		
		//ProcessBuilder builder = new ProcessBuilder(command);
		//Process process = builder.start();
		Process process = Runtime.getRuntime().exec(sb.toString());


		InputStream errorStream = process.getErrorStream();
		InputStreamReader inputStreamReader = new InputStreamReader(errorStream);
		BufferedReader br = new BufferedReader(inputStreamReader);
		
		String line = "";
		while ( (line = br.readLine()) != null ) {
		}
		
		if (br != null) {
			br.close();
		}
		if (inputStreamReader != null) {
			inputStreamReader.close();
		}
		if (errorStream != null) {
			errorStream.close();
		}
		
	}

	public void convertor2(String videoInputPath1, String mp3InputPath,
						  double seconds, String videoInputPath2) throws Exception {
//		ffmpeg.exe -i 苏州大裤衩.mp4 -i bgm.mp3 -t 7 -y 新的视频.mp4
		List<String> command = new ArrayList<>();
		command.add(ffmpegEXE);

		command.add("-i");
		command.add(videoInputPath1);

		command.add("-i");
		command.add(mp3InputPath);

		command.add("-t");
		command.add(String.valueOf(seconds));

		command.add("-y");
		command.add(videoInputPath2);


		for (String c : command) {
			System.out.print(c + " ");
		}
		StringBuilder sb = new StringBuilder();
		for (String c : command) {
			sb.append(c + " ");
		}

		//ProcessBuilder builder = new ProcessBuilder(command);
		//Process process = builder.start();
		Process process = Runtime.getRuntime().exec(sb.toString());

		//ProcessBuilder builder = new ProcessBuilder(command);
		//Process process = builder.start();

		InputStream errorStream = process.getErrorStream();
		InputStreamReader inputStreamReader = new InputStreamReader(errorStream);
		BufferedReader br = new BufferedReader(inputStreamReader);

		String line = "";
		while ( (line = br.readLine()) != null ) {
		}

		if (br != null) {
			br.close();
		}
		if (inputStreamReader != null) {
			inputStreamReader.close();
		}
		if (errorStream != null) {
			errorStream.close();
		}

	}

	public static void main(String[] args) {
		MergeVideoMp3 ffmpeg = new MergeVideoMp3("D:\\学习资料\\抖音全栈\\ffmpeg\\bin\\ffmpeg.exe");
		try {
			//D:/学习资料/抖音全栈/ffmpeg/bin/ffmpeg.exe -i D:/video/190809170770613403648/video/wxc0e8c124994d7dac.o6zAJs6ezCUwIKQCynGuQR6GNHC4.txOpJ6e0DMkJ41b1ef428387bb90467f4e225462ac71.mp4 -c:v copy -an D:/video/190809170770613403648/video/noSoundwxc0e8c124994d7dac.o6zAJs6ezCUwIKQCynGuQR6GNHC4.txOpJ6e0DMkJ41b1ef428387bb90467f4e225462ac71.mp4
			ffmpeg.convertor1("D:/video/190809170770613403648/video/wxc0e8c124994d7dac.o6zAJs6ezCUwIKQCynGuQR6GNHC4.txOpJ6e0DMkJ41b1ef428387bb90467f4e225462ac71.mp4","D:/video/190809170770613403648/video/noSoundwxc0e8c124994d7dac.o6zAJs6ezCUwIKQCynGuQR6GNHC4.txOpJ6e0DMkJ41b1ef428387bb90467f4e225462ac71.mp4");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
