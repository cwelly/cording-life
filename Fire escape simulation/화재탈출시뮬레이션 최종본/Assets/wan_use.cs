using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class wan_use : MonoBehaviour {
    public GameObject sound;
    public int speed;
    int i=0;
    Vector3 docak = new Vector3(160.41f, 48.02f, 66.8f);
    private float waittime;
    // Use this for initialization
    private float fDestroyTime = 2f; private float fTickTime;
    Rigidbody some;
    void Start () {
        some=GetComponent<Rigidbody>();
        some.useGravity = false;
        waittime = 2;
    }
	
	// Update is called once per frame
	void Update () {

        // yield return new WaitForSeconds(0.3f);
        
        fTickTime += Time.deltaTime;
        if (fTickTime >= fDestroyTime&&i==0) // 2초 뒤에 실행
        {
            sound.SendMessage("enableSound");
            transform.position = Vector3.MoveTowards(transform.position, docak, Time.deltaTime * 1.5f);
             some.useGravity = true;
             i++;
             waittime -= Time.deltaTime;
            if (waittime <= 0) {
                SceneManager.LoadScene("Clear");
            }
        }
            
        
    }

    public void CallStop()
    {
        StartCoroutine(StopTimer());
        
    }

    IEnumerator StopTimer()
    {
        
        yield return new WaitForSeconds(1f);
        
    }
}
