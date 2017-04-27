test g00.l0000 { add<infsup<b64>> [0,0] [0,0] = [0,0]_com <= [-0x1.8p-1073,0x1.8p-1073]_com }
test g00.l0001 { add<infsup<b64>> [1,1] [2,2] = [3,3]_com <= [0x1.7fffffffffffep1,0x1.8000000000003p1]_com }
test g00.l0002 { add<infsup<b64>> [-1,-1] [-2,-2] = [-3,-3]_com <= [-0x1.8000000000003p1,-0x1.7fffffffffffep1]_com }
test g00.l0003 { add<infsup<b64>> [1,1] [-1,-1] = [0,0]_com <= [-0x1.8000000000001p-52,0x1.8000000000001p-52]_com }
test g00.l0004 { add<infsup<b64>> [-1,-1] [1,1] = [0,0]_com <= [-0x1.8000000000001p-52,0x1.8000000000001p-52]_com }
test g00.l0005 { add<infsup<b64>> [0x1.fap-1064,0x1.fap-1064] [0x1.fap-1064,0x1.fap-1064] = [0x1.fap-1063,0x1.fap-1063]_com <= [0x1.f9ap-1063,0x1.fa6p-1063]_com }
test g00.l0006 { add<infsup<b64>> [0x1.fap-1064,0x1.fap-1064] [1,1] = [1,0x1.0000000000001p0]_com <= [0x1.ffffffffffffep-1,0x1.0000000000003p0]_com }
test g00.l0007 { add<infsup<b64>> [-0x1.fap-1064,-0x1.fap-1064] [-0x1.fap-1064,-0x1.fap-1064] = [-0x1.fap-1063,-0x1.fap-1063]_com <= [-0x1.fa6p-1063,-0x1.f9ap-1063]_com }
test g00.l0008 { add<infsup<b64>> [-0x1.fap-1064,-0x1.fap-1064] [1,1] = [0x1.fffffffffffffp-1,1]_com <= [0x1.ffffffffffffdp-1,0x1.0000000000002p0]_com }
test g00.l0009 { add<infsup<b64>> [0x1.fffffffffffffp1023,0x1.fffffffffffffp1023] [-1,-1] = [0x1.ffffffffffffep1023,0x1.fffffffffffffp1023]_com <= [0x1.ffffffffffffcp1023,Infinity]_dac }
test g00.l0010 { add<infsup<b64>> [-0x1.fffffffffffffp1023,-0x1.fffffffffffffp1023] [1,1] = [-0x1.fffffffffffffp1023,-0x1.ffffffffffffep1023]_com <= [-Infinity,-0x1.ffffffffffffcp1023]_dac }
test g00.l0011 { add<infsup<b64>> [0,1] [1,2] = [1,3]_com <= [0x1.ffffffffffffdp-1,0x1.8000000000003p1]_com }
test g00.l0012 { add<infsup<b64>> [1,2] [0,1] = [1,3]_com <= [0x1.ffffffffffffdp-1,0x1.8000000000003p1]_com }
test g00.l0013 { add<infsup<b64>> [1,2] [3,4] = [4,6]_com <= [0x1.ffffffffffffdp1,0x1.8000000000003p2]_com }
test g00.l0014 { add<infsup<b64>> [3,4] [1,2] = [4,6]_com <= [0x1.ffffffffffffdp1,0x1.8000000000003p2]_com }
test g00.l0015 { add<infsup<b64>> [-1,0] [-4,-3] = [-5,-3]_com <= [-0x1.4000000000003p2,-0x1.7fffffffffffdp1]_com }
test g00.l0016 { add<infsup<b64>> [-4,-3] [-1,0] = [-5,-3]_com <= [-0x1.4000000000003p2,-0x1.7fffffffffffdp1]_com }
test g00.l0017 { add<infsup<b64>> [-5,-4] [4,5] = [-1,1]_com <= [-0x1.0000000000007p0,0x1.0000000000007p0]_com }
test g00.l0018 { add<infsup<b64>> [4,5] [-5,-4] = [-1,1]_com <= [-0x1.0000000000007p0,0x1.0000000000007p0]_com }
test g00.l0019 { sub<infsup<b64>> [0,0] [0,0] = [0,0]_com <= [-0x1.8p-1073,0x1.8p-1073]_com }
test g00.l0020 { sub<infsup<b64>> [1,1] [2,2] = [-1,-1]_com <= [-0x1.0000000000004p0,-0x1.ffffffffffffbp-1]_com }
test g00.l0021 { sub<infsup<b64>> [-1,-1] [-2,-2] = [1,1]_com <= [0x1.ffffffffffffbp-1,0x1.0000000000004p0]_com }
test g00.l0022 { sub<infsup<b64>> [1,1] [-1,-1] = [2,2]_com <= [0x1.ffffffffffffep0,0x1.0000000000002p1]_com }
test g00.l0023 { sub<infsup<b64>> [-1,-1] [1,1] = [-2,-2]_com <= [-0x1.0000000000002p1,-0x1.ffffffffffffep0]_com }
test g00.l0024 { sub<infsup<b64>> [0x1.fap-1064,0x1.fap-1064] [0x1.fap-1064,0x1.fap-1064] = [0,0]_com <= [-0x1.8p-1073,0x1.8p-1073]_com }
test g00.l0025 { sub<infsup<b64>> [0x1.fap-1064,0x1.fap-1064] [1,1] = [-1,-0x1.fffffffffffffp-1]_com <= [-0x1.0000000000002p0,-0x1.ffffffffffffdp-1]_com }
test g00.l0026 { sub<infsup<b64>> [-0x1.fap-1064,-0x1.fap-1064] [-0x1.fap-1064,-0x1.fap-1064] = [0,0]_com <= [-0x1.8p-1073,0x1.8p-1073]_com }
test g00.l0027 { sub<infsup<b64>> [-0x1.fap-1064,-0x1.fap-1064] [1,1] = [-0x1.0000000000001p0,-1]_com <= [-0x1.0000000000003p0,-0x1.ffffffffffffep-1]_com }
test g00.l0028 { sub<infsup<b64>> [0x1.fffffffffffffp1023,0x1.fffffffffffffp1023] [1,1] = [0x1.ffffffffffffep1023,0x1.fffffffffffffp1023]_com <= [0x1.ffffffffffffcp1023,Infinity]_dac }
test g00.l0029 { sub<infsup<b64>> [-0x1.fffffffffffffp1023,-0x1.fffffffffffffp1023] [-1,-1] = [-0x1.fffffffffffffp1023,-0x1.ffffffffffffep1023]_com <= [-Infinity,-0x1.ffffffffffffcp1023]_dac }
test g00.l0030 { sub<infsup<b64>> [0,1] [1,2] = [-2,0]_com <= [-0x1.0000000000003p1,0x1.8000000000001p-52]_com }
test g00.l0031 { sub<infsup<b64>> [1,2] [0,1] = [0,2]_com <= [-0x1.8000000000001p-52,0x1.0000000000003p1]_com }
test g00.l0032 { sub<infsup<b64>> [1,2] [3,4] = [-3,-1]_com <= [-0x1.8000000000004p1,-0x1.ffffffffffff7p-1]_com }
test g00.l0033 { sub<infsup<b64>> [3,4] [1,2] = [1,3]_com <= [0x1.ffffffffffff7p-1,0x1.8000000000004p1]_com }
test g00.l0034 { sub<infsup<b64>> [-1,0] [-4,-3] = [2,4]_com <= [0x1.ffffffffffffcp0,0x1.0000000000003p2]_com }
test g00.l0035 { sub<infsup<b64>> [-4,-3] [-1,0] = [-4,-2]_com <= [-0x1.0000000000003p2,-0x1.ffffffffffffcp0]_com }
test g00.l0036 { sub<infsup<b64>> [-5,-4] [4,5] = [-10,-8]_com <= [-0x1.4000000000002p3,-0x1.ffffffffffffep2]_com }
test g00.l0037 { sub<infsup<b64>> [4,5] [-5,-4] = [8,10]_com <= [0x1.ffffffffffffep2,0x1.4000000000002p3]_com }
test g00.l0038 { mul<infsup<b64>> [0,0] [0,0] = [0,0]_com <= [-0x1p-1073,0x1p-1073]_com }
test g00.l0039 { mul<infsup<b64>> [-1,-1] [-1,-1] = [1,1]_com <= [0x1.ffffffffffffdp-1,0x1.0000000000004p0]_com }
test g00.l0040 { mul<infsup<b64>> [-1,-1] [0,0] = [0,0]_com <= [-0x1.8p-1073,0x1.8p-1073]_com }
test g00.l0041 { mul<infsup<b64>> [-1,-1] [1,1] = [-1,-1]_com <= [-0x1.0000000000004p0,-0x1.ffffffffffffdp-1]_com }
test g00.l0042 { mul<infsup<b64>> [0,0] [-1,-1] = [0,0]_com <= [-0x1.8p-1073,0x1.8p-1073]_com }
test g00.l0043 { mul<infsup<b64>> [0,0] [1,1] = [0,0]_com <= [-0x1.8p-1073,0x1.8p-1073]_com }
test g00.l0044 { mul<infsup<b64>> [1,1] [-1,-1] = [-1,-1]_com <= [-0x1.0000000000004p0,-0x1.ffffffffffffdp-1]_com }
test g00.l0045 { mul<infsup<b64>> [1,1] [0,0] = [0,0]_com <= [-0x1.8p-1073,0x1.8p-1073]_com }
test g00.l0046 { mul<infsup<b64>> [1,1] [1,1] = [1,1]_com <= [0x1.ffffffffffffdp-1,0x1.0000000000004p0]_com }
test g00.l0047 { mul<infsup<b64>> [0x1.fffffffffffffp1023,0x1.fffffffffffffp1023] [0.5,0.5] = [0x1.fffffffffffffp1022,0x1.fffffffffffffp1022]_com <= [0x1.ffffffffffffcp1022,Infinity]_dac }
test g00.l0048 { mul<infsup<b64>> [-0x1.fffffffffffffp1023,-0x1.fffffffffffffp1023] [0.5,0.5] = [-0x1.fffffffffffffp1022,-0x1.fffffffffffffp1022]_com <= [-Infinity,-0x1.ffffffffffffcp1022]_dac }
test g00.l0049 { mul<infsup<b64>> [0x1.fap-1064,0x1.fap-1064] [0x1.fap-1064,0x1.fap-1064] = [0,0x1p-1074]_com <= [-0x1p-1074,0x1p-1073]_com }
test g00.l0050 { mul<infsup<b64>> [0x1.fap-1064,0x1.fap-1064] [1,1] = [0x1.fap-1064,0x1.fap-1064]_com <= [0x1.f94p-1064,0x1.facp-1064]_com }
test g00.l0051 { mul<infsup<b64>> [0x1.fap-1064,0x1.fap-1064] [-1,-1] = [-0x1.fap-1064,-0x1.fap-1064]_com <= [-0x1.facp-1064,-0x1.f94p-1064]_com }
test g00.l0052 { mul<infsup<b64>> [-3,-2] [-3,-2] = [4,9]_com <= [0x1.ffffffffffffdp1,0x1.2000000000003p3]_com }
test g00.l0053 { mul<infsup<b64>> [-3,-2] [-1,1] = [-3,3]_com <= [-0x1.8000000000004p1,0x1.8000000000004p1]_com }
test g00.l0054 { mul<infsup<b64>> [-3,-2] [2,3] = [-9,-4]_com <= [-0x1.2000000000003p3,-0x1.ffffffffffffdp1]_com }
test g00.l0055 { mul<infsup<b64>> [-1,1] [-3,-2] = [-3,3]_com <= [-0x1.8000000000004p1,0x1.8000000000004p1]_com }
test g00.l0056 { mul<infsup<b64>> [-1,1] [-1,1] = [-1,1]_com <= [-0x1.0000000000004p0,0x1.0000000000004p0]_com }
test g00.l0057 { mul<infsup<b64>> [-1,1] [2,3] = [-3,3]_com <= [-0x1.8000000000004p1,0x1.8000000000004p1]_com }
test g00.l0058 { mul<infsup<b64>> [2,3] [-3,-2] = [-9,-4]_com <= [-0x1.2000000000003p3,-0x1.ffffffffffffdp1]_com }
test g00.l0059 { mul<infsup<b64>> [2,3] [-1,1] = [-3,3]_com <= [-0x1.8000000000004p1,0x1.8000000000004p1]_com }
test g00.l0060 { mul<infsup<b64>> [2,3] [2,3] = [4,9]_com <= [0x1.ffffffffffffdp1,0x1.2000000000003p3]_com }
test g00.l0061 { mul<infsup<b64>> [-5,2] [-4,3] = [-15,20]_com <= [-0x1.e000000000004p3,0x1.4000000000004p4]_com }
test g00.l0062 { mul<infsup<b64>> [-5,2] [-3,8] = [-40,16]_com <= [-0x1.4000000000004p5,0x1.0000000000004p4]_com }
test g00.l0063 { mul<infsup<b64>> [-2,5] [-4,3] = [-20,15]_com <= [-0x1.4000000000004p4,0x1.e000000000004p3]_com }
test g00.l0064 { mul<infsup<b64>> [-4,5] [-4,3] = [-20,16]_com <= [-0x1.4000000000004p4,0x1.0000000000004p4]_com }
test g00.l0065 { mul<infsup<b64>> [-3,0] [-3,-2] = [0,9]_com <= [-0x1.4p-1072,0x1.2000000000003p3]_com }
test g00.l0066 { mul<infsup<b64>> [-3,0] [-1,1] = [-3,3]_com <= [-0x1.8000000000004p1,0x1.8000000000004p1]_com }
test g00.l0067 { mul<infsup<b64>> [-3,0] [2,3] = [-9,0]_com <= [-0x1.2000000000003p3,0x1.4p-1072]_com }
test g00.l0068 { mul<infsup<b64>> [-3,-2] [-3,0] = [0,9]_com <= [-0x1.4p-1072,0x1.2000000000003p3]_com }
test g00.l0069 { mul<infsup<b64>> [-3,-2] [0,3] = [-9,0]_com <= [-0x1.2000000000003p3,0x1.4p-1072]_com }
test g00.l0070 { mul<infsup<b64>> [-1,1] [-3,0] = [-3,3]_com <= [-0x1.8000000000004p1,0x1.8000000000004p1]_com }
test g00.l0071 { mul<infsup<b64>> [-1,1] [0,3] = [-3,3]_com <= [-0x1.8000000000004p1,0x1.8000000000004p1]_com }
test g00.l0072 { mul<infsup<b64>> [0,3] [-3,-2] = [-9,0]_com <= [-0x1.2000000000003p3,0x1.4p-1072]_com }
test g00.l0073 { mul<infsup<b64>> [0,3] [-1,1] = [-3,3]_com <= [-0x1.8000000000004p1,0x1.8000000000004p1]_com }
test g00.l0074 { mul<infsup<b64>> [0,3] [2,3] = [0,9]_com <= [-0x1.4p-1072,0x1.2000000000003p3]_com }
test g00.l0075 { mul<infsup<b64>> [2,3] [-3,0] = [-9,0]_com <= [-0x1.2000000000003p3,0x1.4p-1072]_com }
test g00.l0076 { mul<infsup<b64>> [2,3] [-3,0] = [-9,0]_com <= [-0x1.2000000000003p3,0x1.4p-1072]_com }
test g00.l0077 { mul<infsup<b64>> [0,2] [-3,0] = [-6,0]_com <= [-0x1.8000000000004p2,0x1.4p-1072]_com }
test g00.l0078 { mul<infsup<b64>> [-0x1.fap-1064,-0x1.fap-1064] [-0x1.fap-1064,-0x1.fap-1064] = [0,0x1p-1074]_com <= [-0x1p-1074,0x1p-1073]_com }
test g00.l0079 { mul<infsup<b64>> [-0x1.fap-1064,-0x1.fap-1064] [1,1] = [-0x1.fap-1064,-0x1.fap-1064]_com <= [-0x1.facp-1064,-0x1.f94p-1064]_com }
test g00.l0080 { mul<infsup<b64>> [-0x1.fap-1064,-0x1.fap-1064] [-1,-1] = [0x1.fap-1064,0x1.fap-1064]_com <= [0x1.f94p-1064,0x1.facp-1064]_com }
test g00.l0081 { mul<infsup<b64>> [-0x1.fap-1064,-0x1.fap-1064] [0x1.fap-1064,0x1.fap-1064] = [-0x1p-1074,0]_com <= [-0x1p-1073,0x1p-1074]_com }
test g00.l0082 { mul<infsup<b64>> [-0x1.fap-1064,-0x1.fap-1064] [0,0] = [0,0]_com <= [-0x1p-1073,0x1p-1073]_com }
test g00.l0083 { mul<infsup<b64>> [0x1.fap-1064,0x1.fap-1064] [0,0] = [0,0]_com <= [-0x1p-1073,0x1p-1073]_com }
test g00.l0084 { div<infsup<b64>> [-1,-1] [-1,-1] = [1,1]_com <= [0x1.ffffffffffffcp-1,0x1.0000000000003p0]_com }
test g00.l0085 { div<infsup<b64>> [-1,-1] [1,1] = [-1,-1]_com <= [-0x1.0000000000003p0,-0x1.ffffffffffffcp-1]_com }
test g00.l0086 { div<infsup<b64>> [0,0] [-1,-1] = [0,0]_com <= [-0x1.8p-1073,0x1.8p-1073]_com }
test g00.l0087 { div<infsup<b64>> [0,0] [1,1] = [0,0]_com <= [-0x1.8p-1073,0x1.8p-1073]_com }
test g00.l0088 { div<infsup<b64>> [1,1] [-1,-1] = [-1,-1]_com <= [-0x1.0000000000003p0,-0x1.ffffffffffffcp-1]_com }
test g00.l0089 { div<infsup<b64>> [1,1] [1,1] = [1,1]_com <= [0x1.ffffffffffffcp-1,0x1.0000000000003p0]_com }
test g00.l0090 { div<infsup<b64>> [0x1.fffffffffffffp1023,0x1.fffffffffffffp1023] [2,2] = [0x1.fffffffffffffp1022,0x1.fffffffffffffp1022]_com <= [0x1.ffffffffffffbp1022,Infinity]_dac }
test g00.l0091 { div<infsup<b64>> [-0x1.fffffffffffffp1023,-0x1.fffffffffffffp1023] [2,2] = [-0x1.fffffffffffffp1022,-0x1.fffffffffffffp1022]_com <= [-Infinity,-0x1.ffffffffffffbp1022]_dac }
test g00.l0092 { div<infsup<b64>> [0x1.fap-1064,0x1.fap-1064] [0x1.fap-1064,0x1.fap-1064] = [1,1]_com <= [0x1.ff7e8bd1fbb39p-1,0x1.0040ca78b9431p0]_com }
test g00.l0093 { div<infsup<b64>> [0x1.fap-1064,0x1.fap-1064] [1,1] = [0x1.fap-1064,0x1.fap-1064]_com <= [0x1.f94p-1064,0x1.facp-1064]_com }
test g00.l0094 { div<infsup<b64>> [0x1.fap-1064,0x1.fap-1064] [-1,-1] = [-0x1.fap-1064,-0x1.fap-1064]_com <= [-0x1.facp-1064,-0x1.f94p-1064]_com }
test g00.l0095 { div<infsup<b64>> [-3,-2] [-3,-2] = [0x1.5555555555555p-1,1.5]_com <= [0x1.5555555555552p-1,0x1.8000000000003p0]_com }
test g00.l0096 { div<infsup<b64>> [-3,-2] [2,3] = [-1.5,-0x1.5555555555555p-1]_com <= [-0x1.8000000000003p0,-0x1.5555555555552p-1]_com }
test g00.l0097 { div<infsup<b64>> [-1,1] [-3,-2] = [-0.5,0.5]_com <= [-0x1.0000000000003p-1,0x1.0000000000003p-1]_com }
test g00.l0098 { div<infsup<b64>> [-1,1] [2,3] = [-0.5,0.5]_com <= [-0x1.0000000000003p-1,0x1.0000000000003p-1]_com }
test g00.l0099 { div<infsup<b64>> [2,3] [-3,-2] = [-1.5,-0x1.5555555555555p-1]_com <= [-0x1.8000000000003p0,-0x1.5555555555552p-1]_com }
test g00.l0100 { div<infsup<b64>> [2,3] [2,3] = [0x1.5555555555555p-1,1.5]_com <= [0x1.5555555555552p-1,0x1.8000000000003p0]_com }
test g00.l0101 { div<infsup<b64>> [-3,0] [-3,-2] = [0,1.5]_com <= [-0x1p-1073,0x1.8000000000003p0]_com }
test g00.l0102 { div<infsup<b64>> [-3,0] [2,3] = [-1.5,0]_com <= [-0x1.8000000000003p0,0x1p-1073]_com }
test g00.l0103 { div<infsup<b64>> [0,3] [-3,-2] = [-1.5,0]_com <= [-0x1.8000000000003p0,0x1p-1073]_com }
test g00.l0104 { div<infsup<b64>> [0,3] [2,3] = [0,1.5]_com <= [-0x1p-1073,0x1.8000000000003p0]_com }
