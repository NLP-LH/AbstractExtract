package main.abstractextract.sentenceextract;

import java.util.ArrayList;

import tools.all.FileInputAndOutput;

public class ComponentExtract {
	public static void main(String[] args) {
		ComponentExtract a = new ComponentExtract();
		a.ss();
	}

	public void ss() {	
		ArrayList<String> AbstractString = new ArrayList<String>();
		AbstractString = FileInputAndOutput.readTxtFile2("D:/file/组件.txt");
		for (String s : AbstractString) {
			// 建立个链表，将术语存入，可以用来检验是否重复
			ArrayList<String> WordAssemble = new ArrayList<String>();
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("摘要为：     " + s);
			// 找到包括的定位
			int baokuo = s.indexOf("包括");
			if (baokuo == -1) {
				System.out.println("！！！这句摘要没有“包括关系”");

			} else {
				String beforeword1 = "";
				String beforeword0 = "";
				// 找包括两字前的一个术语
				String aa = ReverseStr(s);
				int beforewordpre1 = aa.indexOf("####)", aa.length() - baokuo);
				int beforewordsuf1 = aa.indexOf("(####", aa.length() - baokuo);
				if (beforewordpre1 != -1 && beforewordsuf1 != -1) {
					// 包括前的那个词
					System.out.println("包括前的术语为：   " + ReverseStr(aa.substring(beforewordpre1 + 5, beforewordsuf1)));
					beforeword1 = aa.substring(beforewordpre1 + 5, beforewordsuf1);
					// 判断前面是否还有术语，然后判断该词是不是前面的一部分
					int beforewordpre0 = aa.indexOf("####)", beforewordsuf1 + 5);
					int beforewordsuf0 = aa.indexOf("(####", beforewordsuf1 + 5);
					// System.out.println(beforewordpre0 +"  "+ beforewordsuf0);
					if (beforewordpre0 != -1 && beforewordsuf0 != -1) {
						System.out.println("再前面的术语是：    " + ReverseStr(aa.substring(beforewordpre0 + 5, beforewordsuf0)));
						beforeword0 = aa.substring(beforewordpre0 + 5, beforewordsuf0);
						if (beforeword0.indexOf(beforeword1) != -1) {
							beforeword1 = beforeword0;
						}
					}
					System.out.println("最终结果是      " + ReverseStr(beforeword1));
				
					System.out.println("-------------------");
				} else {
					System.out.println("包括前面没有-----------------------------词");
					break;
				}

				// 提取包括后面的术语
				s = s.substring(baokuo);
				//System.out.println("包括开始进行截取后:" + s);
				// 找到第一个术语,观察该句是否只有这一个术语，还是一个句子，
				int afterwordpre1 = s.indexOf("####(");
				int afterwordsuf1 = s.indexOf(")####");
				if (afterwordpre1 != -1 && afterwordsuf1 != -1) {
					// 包括后面找到第一个术语
					if (symbol(s.substring(afterwordsuf1 + 5, afterwordsuf1 + 6))) {
						// 第一个术语后面是符号
						System.out.println("后面的一个术语是：  " + s.substring(afterwordpre1 + 5, afterwordsuf1));
						WordAssemble.add(s.substring(afterwordpre1 + 5, afterwordsuf1));
						// if (afterwordpre1 < 7) {
						// 句子里只有一个术语
						String fuhao = s.substring(afterwordsuf1 + 5, afterwordsuf1 + 6);
						s = s.substring(afterwordsuf1 + 6);
						int afterwordpre2 = s.indexOf("####(");
						int afterwordsuf2 = s.indexOf(")####");
						if (afterwordpre2 != -1 && afterwordsuf2 != -1) {
							System.out.println("再后面的一个术语是：  " + s.substring(afterwordpre2 + 5, afterwordsuf2));

							if (symbol(s.substring(afterwordsuf2 + 5, afterwordsuf2 + 6))) {
								// 第二个术语后面是符号

								if (s.substring(afterwordsuf2 + 5, afterwordsuf2 + 6).equals(fuhao)) {
									// 第二个术语后的符号和第一个术语一样

									// 术语加入链表
									WordAssemble.add(s.substring(afterwordpre2 + 5, afterwordsuf2));
									// 不断的提取以符号结束的术语
									s = s.substring(afterwordsuf2 + 6);
									for (;;) {
										int afterwordpre3 = s.indexOf("####(");
										int afterwordsuf3 = s.indexOf(")####");
										if (afterwordpre3 != -1 && afterwordsuf3 != -1) {
											System.out.println("再再后面的一个术语是：  " + s.substring(afterwordpre3 + 5, afterwordsuf3));
											boolean juedge = false;
											if (s.substring(afterwordsuf3 + 5, afterwordsuf3 + 6).equals(fuhao) || s.substring(afterwordsuf3 + 5, afterwordsuf3 + 6).equals("和") || s.substring(afterwordsuf3 + 5, afterwordsuf3 + 6).equals("及")) {
												juedge = true;
											} else {
												if (symbol(s.substring(afterwordsuf3 + 5, afterwordsuf3 + 6))) {
													WordAssemble.add(s.substring(afterwordpre3 + 5, afterwordsuf3));
													break;
												}
											}
											if (s.substring(afterwordsuf3 + 5, afterwordsuf3 + 6).equals("以")) {

												if (s.substring(afterwordsuf3 + 6, afterwordsuf3 + 7).equals("及")) {
													juedge = true;
												}
											}
											if (juedge == true) {
												WordAssemble.add(s.substring(afterwordpre3 + 5, afterwordsuf3));
												s = s.substring(afterwordsuf3 + 6);
											} else {
												break;
											}
										} else {
											break;
										}
									}
								} else {
									// 第二个术语后面的符号跟第一个不一样

									if (afterwordpre2 < 2) {
										WordAssemble.add(s.substring(afterwordpre2 + 5, afterwordsuf2));
										s = s.substring(afterwordsuf1 + 5);
										int afterwordpre3 = s.indexOf("####(");
										int afterwordsuf3 = s.indexOf(")####");
										if (afterwordpre3 != -1 && afterwordsuf3 != -1) {
											if (s.substring(0, 1).equals("及") || s.substring(0, 1).equals("和")) {
												if (symbol(s.substring(afterwordsuf3 + 5, afterwordsuf3 + 6))) {

													WordAssemble.add(s.substring(afterwordpre3 + 5, afterwordsuf3));
												}
												// break;
											}
										}
									}
								}
							} else {

								// 第二个术语后面不是符号
								// 可能是和、以及
								if (s.substring(afterwordsuf2 + 5, afterwordsuf2 + 6).equals("及") || s.substring(afterwordsuf2 + 5, afterwordsuf2 + 6).equals("和")) {
									WordAssemble.add(s.substring(afterwordpre2 + 5, afterwordsuf2));
									s = s.substring(afterwordsuf2 + 5);
									int afterwordpre3 = s.indexOf("####(");
									int afterwordsuf3 = s.indexOf(")####");
									if (afterwordpre3 != -1 && afterwordsuf3 != -1) {
										if (symbol(s.substring(afterwordsuf3 + 5, afterwordsuf3 + 6))) {
											WordAssemble.add(s.substring(afterwordpre3 + 5, afterwordsuf3));
										}
										// break;
									}
								} else {
									if (s.substring(afterwordsuf2 + 5, afterwordsuf2 + 6).equals("以")) {
										if (s.substring(afterwordsuf2 + 6, afterwordsuf2 + 7).equals("及")) {
											WordAssemble.add(s.substring(afterwordpre2 + 5, afterwordsuf2));
											s = s.substring(afterwordsuf2 + 5);
											int afterwordpre3 = s.indexOf("####(");
											int afterwordsuf3 = s.indexOf(")####");
											if (afterwordpre3 != -1 && afterwordsuf3 != -1) {
												if (symbol(s.substring(afterwordsuf3 + 5, afterwordsuf3 + 6))) {
													WordAssemble.add(s.substring(afterwordpre3 + 5, afterwordsuf3));
												}
												// break;
											}
										}
									} else {
										// 第二个术语后面不是符号也不是和、以及等
										// 写大段代码
										//System.out.println("!!!!!!!! 22");
										s = s.substring(afterwordsuf1 + 5);
										String fuhao2 = "";
										for (;;) {
											afterwordpre2 = s.indexOf("####(");
											afterwordsuf2 = s.indexOf(")####");
											if (afterwordpre2 != -1 && afterwordsuf2 != -1) {
												if (symbol(s.substring(afterwordsuf2 + 5, afterwordsuf2 + 6))) {
													if (s.substring(afterwordsuf2 + 5, afterwordsuf2 + 6).equals(fuhao)) {
														System.out.println(s);
														System.out.println("11" + s.substring(afterwordpre2 + 5, afterwordsuf2));
														WordAssemble.add(s.substring(afterwordpre2 + 5, afterwordsuf2));
														s = s.substring(afterwordsuf2 + 5);
													} else {
														if (fuhao2.equals("")) {
															fuhao2 = s.substring(afterwordsuf2 + 5, afterwordsuf2 + 6);
														} else {
															if (s.substring(afterwordsuf2 + 5, afterwordsuf2 + 6).equals(fuhao2)) {
																s = s.substring(afterwordsuf2 + 5);
															} else {
																System.out.println("22" + s.substring(afterwordpre2 + 5, afterwordsuf2));
																WordAssemble.add(s.substring(afterwordpre2 + 5, afterwordsuf2));
																break;
															}
														}
													}
												} else {
													s = s.substring(afterwordsuf2 + 5);
												}
											} else {
												break;
											}
										}
									}
								}
							}
						} else {
							// 不存在第二个术语，不用写代码
						}
					} else {
						// 术语后面不是符号
						if (s.substring(afterwordsuf1 + 5, afterwordsuf1 + 6).equals("及") || s.substring(afterwordsuf1 + 5, afterwordsuf1 + 6).equals("和")) {
							WordAssemble.add(s.substring(afterwordpre1 + 5, afterwordsuf1));
							s = s.substring(afterwordsuf1 + 5);
							int afterwordpre2 = s.indexOf("####(");
							int afterwordsuf2 = s.indexOf(")####");
							if (afterwordpre2 != -1 && afterwordsuf2 != -1) {
								if (s.substring(0, 1).equals("及") || s.substring(0, 1).equals("和")) {
									if (symbol(s.substring(afterwordsuf2 + 5, afterwordsuf2 + 6))) {

										WordAssemble.add(s.substring(afterwordpre2 + 5, afterwordsuf2));
									}

									// break;
								}
							}
						} else {
							// 大段代码，第一个术语就是一句话

							// 找到一句话中的最后一个术语，判断后面是符号，再存入符号，如果左边是和、以及等，再把左边的加入
							String fuhao = "";
							for (;;) {
								System.out.println("1!!!" + s);
								int afterwordpre11 = s.indexOf("####(");
								int afterwordsuf11 = s.indexOf(")####");
								if (afterwordpre11 != -1 && afterwordsuf11 != -1) {
									if (symbol(s.substring(afterwordsuf11 + 5, afterwordsuf11 + 6))) {
										if (s.substring(afterwordsuf11 + 5, afterwordsuf11 + 6).equals(fuhao) || fuhao.equals("")) {

											System.out.println("1!!!" + s.substring(afterwordpre11 + 5, afterwordsuf11));
											WordAssemble.add(s.substring(afterwordpre11 + 5, afterwordsuf11));
											fuhao = s.substring(afterwordsuf11 + 5, afterwordsuf11 + 6);
											s = s.substring(afterwordsuf11 + 6);

										} else {
											WordAssemble.add(s.substring(afterwordpre11 + 5, afterwordsuf11));
											System.out.println("1!!!" + s.substring(afterwordpre11 + 5, afterwordsuf11));
											break;
								
										}
									} else {
										s = s.substring(afterwordsuf11 + 6);
									}
								} else {
									break;
								}
							}
						}
					}
				} else {
					System.out.println(" 包括后面居然没有术语！  ");
				}
				//去重，然后存储
				System.out.println("end");
				for (String wa : WordAssemble) {
					System.out.println(wa);
				}
			}
		}
	}

	public boolean repeat(String word, ArrayList<String> words) {
		boolean rep = false;
		return rep;
	}

	public boolean symbol(String s) {
		boolean symbol = false;
		if (s.equals(",") || s.equals("，") || s.equals("。") || s.equals("；") || s.equals(";") || s.equals("：") || s.equals("、")) {
			symbol = true;
		}
		return symbol;
	}

	public String ReverseStr(String s) {
		StringBuilder sb = new StringBuilder(s);
		String Rev = sb.reverse().toString();
		return Rev;
	}
}
