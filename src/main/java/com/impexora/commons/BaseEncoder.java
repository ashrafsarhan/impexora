/**
 * 
 */
package com.impexora.commons;

import org.apache.log4j.Logger;

/**
 * @author ashraf_sarhan
 *
 */
public class BaseEncoder {
	
	private static Logger logger = Logger.getLogger(BaseEncoder.class.getSimpleName());

	public static final String BASE_36_ALPHABET = " abcdefghijklmnopqrstuvwxyz1234567890";

	private String alphabet;

	public BaseEncoder()
	{
		this.alphabet = BASE_36_ALPHABET;
		logger.info("using base 36 default alphabet");
	}

	public BaseEncoder(String alphabet)
	{
		this.alphabet = alphabet;
	}

	public int getBase()
	{
		return this.alphabet.length() - 1;
	}

	public String encode(long toEncode)
	{
		// logger.debug(this, "encoding: " + toEncode);

		StringBuilder sb = new StringBuilder();

		if (toEncode > 0)
		{
			long temp = toEncode;
			long base = getBase();
			long dividend = temp;

			if (base > 0)
			{
				while (temp > base)
				{
					if (temp > 0)
					{
						dividend = temp / base;
						long remainder = temp % base;
						sb.append(this.alphabet.charAt((int) remainder));

						temp = dividend;
					}
					else
					{
						throw new IllegalArgumentException(
								"number cannot divide by 0");
					}
				}

				// add the last dividend
				if (dividend > 0)
				{
					sb.append(this.alphabet.charAt((int) dividend));
				}
			}
			else
			{
				throw new IllegalArgumentException("base cannot be less than 0");
			}
		}
		else
		{
			throw new IllegalArgumentException("number cannot be negative");
		}

		StringBuilder reversedString = sb.reverse();

		return reversedString.toString();
	}

	public long decode(String toDecode)
	{
		long number = 0;

		if (toDecode != null && !toDecode.isEmpty())
		{
			long base = getBase();
			long strLength = toDecode.length();

			if (base > 0)
			{
				for (int i = 0; i < strLength; i++)
				{
					char c = toDecode.charAt(i);
					int result = this.alphabet.indexOf(c);

					if (result >= 0)
					{
						// find the power of the base
						long power = strLength - i - 1;
						number += (result * (Math.pow(base, power)));
					}
					else
					{
						throw new IllegalArgumentException(
								"symbol not in alphabet");
					}
				}
			}
			else
			{
				throw new IllegalArgumentException("base cannot be less than 0");
			}
		}
		else
		{
			throw new IllegalArgumentException("input cannot be empty or null");
		}

		return number;
	}

}
