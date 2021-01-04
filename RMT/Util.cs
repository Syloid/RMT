﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Runtime.InteropServices;
using System.Text.RegularExpressions;

namespace RMT
{
    public static class Util
    {
        [DllImport("shlwapi.dll", EntryPoint = "PathRelativePathTo")]
        static extern bool PathRelativePathTo(StringBuilder lpszDst,
            string from, UInt32 attrFrom,
            string to, UInt32 attrTo);

        public static string GetRelativePath(string from, string to)
        {
            StringBuilder builder = new StringBuilder(1024);
            bool result = PathRelativePathTo(builder, from, 0, to, 0);
            return "\""+builder.Replace(@"\","/").ToString()+"\"";
        }

        /*
         * Fetches a float number from the '=' character of the line passed through params
         */
        public static float FetchFloatNumber(string line)
        {
            var floatNumber = 1.0;
            String substring = line.Substring(line.IndexOf("="));
            var match = Regex.Match(substring, @"([-+]?[0-9]*\.?[0-9]+)");
            if (match.Success)
                floatNumber = Convert.ToSingle(match.Groups[1].Value);

            return (float)floatNumber;
        }

        /*
         * Fetches an integer number
         */
        public static int FetchNumberParamValue(string line)
        {
            String resultString = Regex.Match(line, @"\d+").Value;
            int value = -1;
            int.TryParse(resultString, out value);
            return value;
        }

        /*
         * Fetches a string value between char character (usually a "\"")
         */
        public static String FetchSubStringBetween(String line, char character, bool excludeLastCharacter = false, int firstCharacterPadding = 0)
        {

            String substring = line.Substring(line.IndexOf(character) + firstCharacterPadding);
            if (excludeLastCharacter)
                substring = substring.Remove(substring.Length - 1);

            return substring;
        }
    }
}
