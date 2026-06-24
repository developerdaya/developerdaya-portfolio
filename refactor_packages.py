import os

directory = 'shared/src/commonMain/kotlin/com/developerdaya/portfolio'

for root, dirs, files in os.walk(directory):
    for file in files:
        if file.endswith('.kt'):
            file_path = os.path.join(root, file)
            with open(file_path, 'r', encoding='utf-8') as f:
                content = f.read()
            
            new_content = content.replace('package com.app', 'package com.developerdaya.portfolio')
            new_content = new_content.replace('import com.app', 'import com.developerdaya.portfolio')
            
            if new_content != content:
                with open(file_path, 'w', encoding='utf-8') as f:
                    f.write(new_content)
                print(f"Updated {file_path}")

print("Done replacing packages.")
